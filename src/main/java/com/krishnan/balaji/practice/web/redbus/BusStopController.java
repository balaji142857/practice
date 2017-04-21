package com.krishnan.balaji.practice.web.redbus;

import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.a.BusStop;
import com.krishnan.balaji.practice.model.a.Place;
import com.krishnan.balaji.practice.service.redbus.BusOperatorService;
import com.krishnan.balaji.practice.service.redbus.BusStopService;
import com.krishnan.balaji.practice.service.redbus.PlaceService;

@Controller
@RequestMapping("/redbus/operators/{operatorId}/busStops/")
public class BusStopController {

	@Autowired
	PlaceService placeService;
	@Autowired
	BusStopService service;
	@Autowired 
	BusOperatorService operatorService;

	private static final String viewFolderPrefix = "redbus/operators/busStop/";
	private static final Logger log = LoggerFactory.getLogger(BusStopController.class);

	@ModelAttribute(name = "availablePlaces")
	public Set<Place> something() {
		return placeService.listAll();
	}
	
	@GetMapping("new")
	public ModelAndView serveNewStopRequest(@PathVariable long operatorId) {
		BusStop stop = new BusStop();
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "new");
		mav.getModelMap().addAttribute("newBusStop", stop);
		mav.getModelMap().put("operatorId", operatorId);
		return mav;
	}
	
	@PostMapping("confirm") 
	public ModelAndView validateNewBusStopRequest(@Valid BusStop busStop,
			BindingResult result,
			HttpSession session,
			@PathVariable long operatorId,
			@RequestParam(name="place") String place,
			@RequestParam(name="time") String time){
		ModelAndView mav = null;
		if(result.hasErrors()){
			log.info(" form has errors");
			for(ObjectError error: result.getAllErrors()){
				log.error(error.getObjectName()+":"+error.getCode()+":"+error.getDefaultMessage());
			}
			mav = new ModelAndView(viewFolderPrefix+"new");
			mav.getModelMap().put("newBusStop", busStop);			
		}else{
			busStop.setOperator(operatorService.get(operatorId));
			logBusStop(busStop);
			mav = new ModelAndView(viewFolderPrefix+"confirm");
			session.setAttribute("validatedBusStop", busStop);
			mav.getModelMap().put("validatedBusStop", busStop);
			mav.getModelMap().put("operatorId", operatorId);
		}
		return mav;
	}
	

	@PostMapping("new")
	public ModelAndView handleNewBusStopRequest(HttpSession session,
			@PathVariable long operatorId,
			RedirectAttributes redirectAttribute){
		ModelAndView mav = new ModelAndView("redirect:/redbus/operators/"+operatorId+"/busStops/list");
		BusStop busStop = (BusStop) session.getAttribute("validatedBusStop");
		service.create(busStop);
		session.removeAttribute("validatedBusStop");
		redirectAttribute.addFlashAttribute("message","BusStop created successfuly");
		return mav;
	}


	@GetMapping("list")
	public ModelAndView listStops(@PathVariable long operatorId,
			@RequestParam(name="pageNumber",required=false) Integer pageNumber){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"list");
		Set<BusStop> busStops = null;
		if(null != pageNumber && pageNumber>0)
			busStops= service.list(pageNumber);
		else
			busStops =  service.list(0);
		log.info("pringin the busStop details");
		for(BusStop busStop : busStops)
			logBusStop(busStop);
		mav.getModelMap().put("operatorId", operatorId);
		mav.getModelMap().put("busStops", busStops);
		return mav;
	}
	
	private void logBusStop(BusStop busStop) {
		if(busStop== null)
			log.info(" busStop is null");
		else{
			log.info("busStop place "+busStop.getPlace());
			if(busStop.getPlace()!=null)
				log.info(busStop.getPlace().getLocation());
			else
				log.info("busStop place is null");
			log.info("busStop time is "+busStop.getTime());
		}
	}
}
