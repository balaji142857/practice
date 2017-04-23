package com.krishnan.balaji.practice.web.redbus;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.BusStop;
import com.krishnan.balaji.practice.model.a.Route;
import com.krishnan.balaji.practice.service.redbus.BusOperatorService;
import com.krishnan.balaji.practice.service.redbus.BusStopService;
import com.krishnan.balaji.practice.service.redbus.RouteService;
import com.krishnan.balaji.practice.util.BusStopTimeSort;

@Controller
@RequestMapping("/redbus/operators/{operatorId}/routes/")
public class RouteController {

	
	private static final String viewFolderPrefix = "redbus/operators/route/";
	private static final Logger log = LoggerFactory.getLogger(RouteController.class);
	
	public RouteController(){
		log.error("RouteController constructed");
	}

	@Autowired
	RouteService service;
	@Autowired
	BusOperatorService operatorService;
	@Autowired
	BusStopService busStopService;

	@GetMapping("new")
	public ModelAndView serveNewRouteRequest(@PathVariable long operatorId) {
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "new");
		Route route = new Route();
		mav.getModelMap().put("newRoute", route);
		// TODO get it from properties file, use a resourceBundle
		mav.getModelMap().put("message", "Just select the busStops, it will be automaticaly ordered by time");
		BusOperator operator = operatorService.get(operatorId);
		List<BusStop> a = busStopService.getByOperator(operator);
		mav.getModelMap().put("availableStops", a);
		// availableStops
		return mav;
	}

	@PostMapping("confirm")
	public ModelAndView hadleNewRouteValidation(@PathVariable long operatorId, @Valid Route route, BindingResult result,
			HttpSession session) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			log.info(" form has errors");
			for (ObjectError error : result.getAllErrors()) {
				log.error("errorInNewRoute: " + error.getObjectName() + ":" + error.getCode() + ":"
						+ error.getDefaultMessage());
			}
			mav = new ModelAndView(viewFolderPrefix + "new");
			mav.getModelMap().put("newRoute", route);
		} else {
			mav = new ModelAndView(viewFolderPrefix + "confirm");
			BusOperator operator = operatorService.get(operatorId);
			if (route.getStops() != null) {
				//TODO dont create a new instance everytime
				Collections.sort(route.getStops(),new BusStopTimeSort());
				boolean first = true;
				BusStop lastStop = null;
				for (BusStop stop : route.getStops()) {
					log.error("mapping buStop to route " + route.getName());
					stop.setRoute(route);
					if (first) {
						first = false;
						route.setOrigin(stop);
					}
					lastStop = stop;
				}
				route.setDestination(lastStop);
				BusStop firstStop = route.getOrigin();
				
				
				if (firstStop.getDay() == lastStop.getDay()) {
					route.setJourneyTime(Duration.between(firstStop.getArrival(), lastStop.getDeparture()));
				}
				else{
					//TODO LocalTime.Midnight might be better fit - test it
					Duration firstDayDuration = Duration.between(firstStop.getArrival(), LocalTime.of(23, 59)).plusMinutes(1);
					Duration inBetween = Duration.ofHours((lastStop.getDay()-1)*24);
					Duration lastDayDuration = Duration.between(LocalTime.of(0, 0), lastStop.getDeparture());
					route.setJourneyTime(firstDayDuration.plus(lastDayDuration).plus(inBetween));
				}
				log.info("Route duration is "+route.getJourneyTime());
			} else
				log.error("busStops of route is null");

			route.setOperator(operator);
			session.setAttribute("validatedRoute", route);
			mav.getModelMap().put("validatedRoute", route);
		}
		return mav;
	}

	@PostMapping("new")
	public ModelAndView handleNewRouteRequest(HttpSession session, RedirectAttributes redirectAttributes,
			@PathVariable long operatorId) {
		ModelAndView mav = new ModelAndView("redirect:/redbus/operators/" + operatorId + "/routes/list");
		Route route = (Route) session.getAttribute("validatedRoute");
		service.create(route);
		session.removeAttribute("validatedRoute");
		redirectAttributes.addFlashAttribute("message", "Route " + route.getName() + " create successfuly");
		return mav;
	}

	@GetMapping("list")
	public ModelAndView servicRoutesListRequest(@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@PathVariable long operatorId) {
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "list");
		if (pageNum == null || pageNum < 0)
			pageNum = 0;
		mav.getModelMap().put("routes", service.list(pageNum));
		mav.getModelMap().put("operatorId", operatorId);
		return mav;
	}

}
