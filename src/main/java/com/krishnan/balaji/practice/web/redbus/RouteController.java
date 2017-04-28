package com.krishnan.balaji.practice.web.redbus;

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
/**
 * 
 * No edit functionality for Route, will have to delete and recreate if needed
 *
 */
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
		if (pageNum == null || pageNum <= 0)
			pageNum = 1;
		BusOperator operator = operatorService.get(operatorId);
		List<Route> routes = service.listByOperator(pageNum, operator);
		mav.getModelMap().put("routes", routes);
		mav.getModelMap().put("operatorId", operatorId);
		mav.getModelMap().put("currentPage", pageNum);
		return mav;
	}

}

