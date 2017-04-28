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
			@RequestParam(name="editExistingRequest",required=false) String isEditExistingRequest,
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
		if(isEditExistingRequest !=null && Boolean.valueOf(isEditExistingRequest))
			mav.getModelMap().put("editExisting", true);
		return mav;
	}
	
	@PostMapping("/new")
	public ModelAndView handleNewBusRequest(HttpSession session,
			@PathVariable long operatorId,
			@RequestParam(name="edit",required=false) String isEdit){
		log.info("handling new bus request "+operatorId+" and edit is "+isEdit);
		ModelAndView mav = null;
		if(isEdit==null){
			Bus bus = (Bus) session.getAttribute("validatedBus");
			bus = service.addBus(operatorId, bus);
			session.removeAttribute("validatedBus");
			mav = new ModelAndView("redirect:/redbus/operators/"+operatorId+"/buses/list");
			mav.getModelMap().put("message", "Bus "+bus.getRegNumber()+" created succssfuly ");
		}
		log.info("returning mav: "+mav.getViewName());
		return mav;
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView serveEditBusRequest(@PathVariable long operatorId,
			@PathVariable long id){
		log.info("serving edit bus request");
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"new");
		Bus bus = service.getBus(operatorId, id);
		mav.getModelMap().put("newBus", bus);
		mav.getModelMap().put("editExisting", true);
		return mav;
	}
	
	@PostMapping("/{id}/edit")
	public ModelAndView handleEditBusRequest(HttpSession session,
			@PathVariable long operatorId,
			@PathVariable long id,
			RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("redirect:/redbus/operators/"+operatorId+"/buses/list");
		Bus editedBus = (Bus) session.getAttribute("validatedBus");
		Bus persistentBus = service.getBus(operatorId, id);
		merge(persistentBus,editedBus);
		editedBus = service.edit(operatorId, persistentBus);
		session.removeAttribute("validatedBus");
		redirectAttributes.addFlashAttribute("message", "Bus "+editedBus.getRegNumber()+" edited successfuly");
		return mav;
	}
	
	private void merge(Bus persistentBus, Bus editedBus) {
		persistentBus.setBusType(editedBus.getBusType());	
		persistentBus.setChargingAvailable(editedBus.isChargingAvailable());
		persistentBus.setGpsTrackingAvailable(editedBus.isGpsTrackingAvailable());
		persistentBus.setModel(editedBus.getModel());
		persistentBus.setRegNumber(editedBus.getRegNumber());
		persistentBus.setSeatCapacity(editedBus.getSeatCapacity());
	}
	@GetMapping(value={"/list","/"})
	public ModelAndView servetListRequest(@PathVariable long operatorId,
			@RequestParam(name="pageNumber",required=false) Long pageNumber){
		if(pageNumber == null || pageNumber <=1 )
			pageNumber = 1l;
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"list");
		BusOperator operator  = service.get(operatorId, true);
		mav.getModelMap().put("buses", operator.getBuses());
		mav.getModelMap().put("currentPage", pageNumber);
		
		
		return mav;
	}

	@ModelAttribute("busTypes")
	public BusType[] busTypes(){
		return BusType.values();
	}
}