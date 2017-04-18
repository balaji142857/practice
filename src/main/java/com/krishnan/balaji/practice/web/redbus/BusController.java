package com.krishnan.balaji.practice.web.redbus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.BusType;
import com.krishnan.balaji.practice.service.redbus.BusOperatorService;

@Controller
@RequestMapping("/redbus/operators/{operatorId}/buses")
public class BusController {
	
	private static final String viewFolderPrefix ="redbus/operators/bus/";
	private static final Logger log = LoggerFactory.getLogger(BusController.class);
	@Autowired
	BusOperatorService service;
	
	public BusController() {
		log.info("Bus Controller is constructed");
	}
	@GetMapping("/new")
	public ModelAndView serveNewBusRequest(@PathVariable long operatorId){
		log.info("serving new bus request");
		Bus bus = new Bus();
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"new");
		mav.getModelMap().put("newBus", bus);
		mav.getModelMap().put("operatorId", operatorId);
		return mav;
	}
	
	@PostMapping("/confirm")
	public ModelAndView handleConfirmationRequest(@Valid Bus bus,
			BindingResult result,
			@RequestParam(value="editRequest",required=false) String isEditRequest,
			@RequestParam(value="editExistingRequest",required=false) String isEditExistingRequest,
			@PathVariable long operatorId,
			HttpSession session){
		ModelAndView mav = null;
		if(result.hasErrors()){
			mav = new ModelAndView(viewFolderPrefix+"new");
			mav.getModelMap().put("newBus", bus);
			mav.getModelMap().put("operatorId", operatorId);
		}else{
			mav = new ModelAndView(viewFolderPrefix+"confirm");
			mav.getModelMap().put("validatedBus", bus);	
			session.setAttribute("validatedBus", bus);
		}
		return mav;
	}
	
	@PostMapping("/new")
	public ModelAndView handleNewBusRequest(HttpSession session,
			@PathVariable long operatorId,
			@RequestParam(name="edit",required=false) String isEdit,
			RedirectAttributes redirectAttributes){
		ModelAndView mav = null;
		if(isEdit==null){
			Bus bus = (Bus) session.getAttribute("validatedBus");
			service.addBus(operatorId, bus);
			session.removeAttribute("validatedBus");
			mav = new ModelAndView("redirect:/redbus/operators/"+operatorId+"/");
			BusOperator operator = service.get(operatorId);
			mav.getModelMap().put("operator", operator);
		}
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView serveEditBusRequest(@Valid BusOperator operator){
		log.info("serving edit bus request");
		ModelAndView mav = null;
		return mav;
	}
	
	@PostMapping("/edit")
	public ModelAndView handleEditBusRequest(@Valid BusOperator operator){
		ModelAndView mav = null;
		return mav;
	}

	@ModelAttribute("busTypes")
	public BusType[] busTypes(){
		return BusType.values();
	}
}