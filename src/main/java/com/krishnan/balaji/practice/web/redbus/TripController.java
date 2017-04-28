package com.krishnan.balaji.practice.web.redbus;

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
import com.krishnan.balaji.practice.model.a.Trip;
import com.krishnan.balaji.practice.service.redbus.BusOperatorService;
import com.krishnan.balaji.practice.service.redbus.RouteService;
import com.krishnan.balaji.practice.service.redbus.TripService;

@Controller
@RequestMapping("/redbus/operators/{operatorId}/trips/")
public class TripController {
	
	public static final String viewFolderPrefix = "redbus/operators/trip/";
	private static final Logger log = LoggerFactory.getLogger(TripController.class);
	@Autowired TripService service;
	@Autowired BusOperatorService operatorService;
	@Autowired RouteService routeService;
	
	
	@GetMapping("new")
	public ModelAndView serveNewTripRequest(@PathVariable long operatorId){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"new");
		Trip trip = new Trip();
		BusOperator operator = operatorService.get(operatorId, true);
		trip.setOperator(operator);
		mav.getModelMap().put("availableRoutes", routeService.listAllByOperator(operator));
		mav.getModelMap().put("newTrip", trip);
		return mav;
	}
	
	@PostMapping("confirm")
	public ModelAndView hadleNewTripSubmission(@Valid Trip trip,
			@PathVariable long operatorId,
			BindingResult result,
			HttpSession session){
		ModelAndView mav = null;
		if(result.hasErrors()){
			log.info("Trip has errors :( ");
			for (ObjectError a : result.getAllErrors())
				log.info(a.getObjectName() +" :  " + a.getDefaultMessage());
			mav = new ModelAndView(viewFolderPrefix+"new");
			mav.getModelMap().put("newTrip",trip);
		}else{
			mav =  new ModelAndView(viewFolderPrefix+"confirm");
			mav.getModelMap().put("validatedTrip", trip);
			mav.getModelMap().put("operatorId", operatorId);
			session.setAttribute("validatedTrip", trip);
		}
		return mav;
	}

	@PostMapping("new")
	public ModelAndView handleNewTripRequest(HttpSession session,
			@RequestParam(required=false,name="edit") String editNewTrip,
			@PathVariable long operatorId,
			RedirectAttributes redirectAttributes){
		ModelAndView mav = null;
		Trip trip = (Trip) session.getAttribute("validatedTrip");
		session.removeAttribute("validatedTrip");
		if(editNewTrip!=null && editNewTrip.equalsIgnoreCase("edit")){
			mav =  new ModelAndView(viewFolderPrefix+"new");
			mav.getModelMap().put("newTrip", trip);
		}else{
			mav =  new ModelAndView("redirect:/redbus/operators/"+operatorId+"/");
			trip = service.create(trip);
			redirectAttributes.addFlashAttribute("message","Trip created successfuly");
		}
		return mav;
	}
	
	@GetMapping("{tripId}/edit")
	public ModelAndView serveTripEditRequest(@PathVariable long operatorId,
			@PathVariable long tripId){
		ModelAndView mav =  new ModelAndView(viewFolderPrefix+"new");
		mav.getModelMap().put("editExisting", true);
		return mav;
	}
	
	@PostMapping("{tripId}/edit")
	public ModelAndView handleEditRequest(){
		ModelAndView mav = null;
		return mav;
	}
	
	@GetMapping("list")
	public ModelAndView serveTripRequestLists(@PathVariable long opratorId,
			@RequestParam(name="pageNumber",required=false) long pageNumber){
		ModelAndView mav = null;
		mav = new ModelAndView(viewFolderPrefix+"list");
		BusOperator operator = operatorService.get(opratorId);
		mav.getModelMap().put("trips", service.listByOperator(operator));
		return mav;
	}

}