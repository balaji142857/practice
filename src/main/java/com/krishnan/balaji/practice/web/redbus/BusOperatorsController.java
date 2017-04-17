package com.krishnan.balaji.practice.web.redbus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.service.redbus.OperatorService;

@Controller()
@RequestMapping("/redbus/operators")
public class BusOperatorsController {

	private static final String viewFolderPrefix ="/redbus/operators/";
	
	@Autowired
	OperatorService service;

	@GetMapping("/")
	public ModelAndView serveListOperatorsRequest(){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"operators");
		mav.getModelMap().put("operators", service.list());
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView serveNewOperatorRequest(HttpSession session){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"operator_new");
		mav.getModelMap().put("newOperator", new BusOperator());
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView serveOperatorEditRequest(@PathVariable long id){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"operator_new");
		BusOperator operator = service.get(id);
		mav.getModelMap().put("newOperator", operator);
		mav.getModelMap().put("editExistingRequest", "true");
		return mav;
	}
	
	@PostMapping("/confirm")
	public ModelAndView handleConfirmationRequest(@Valid BusOperator operator,
			BindingResult result,
			@RequestParam(value="editRequest",required=false) String isEditRequest,
			@RequestParam(value="editExistingRequest",required=false) String isEditExistingRequest,
			HttpSession session){
		ModelAndView mav = null;
		if(result.hasErrors()){
			mav = new ModelAndView(viewFolderPrefix+"operator_new");
			//notify where error was obtained - creating new user/editing while creating new user/editing existing user
			String value = null;
			if(null != isEditRequest && Boolean.valueOf(isEditRequest)){
				value ="Below errors were observed while processing the edit request for new operator";
				mav.getModelMap().put("editRequest", true);
			}
			else if (null !=isEditExistingRequest && Boolean.valueOf(isEditExistingRequest)){
				value ="Below errors were observed while processing the edit request for existing operator";
				mav.getModelMap().put("editExistingRequest", true);
			}
			else{
				value="Below errors were observed while processing the request for new operator";
			}
			mav.getModelMap().put("message", value);
		}else{
			mav = new ModelAndView(viewFolderPrefix+"operator_confirm");
			session.setAttribute("validatedOperator", operator);
			mav.getModelMap().put("validatedOperator", operator);
			if (null !=isEditExistingRequest && Boolean.valueOf(isEditExistingRequest)){
				mav.getModelMap().put("editExistingRequest",true );
			}
		}
		return mav;
	}
	
	@PostMapping("/new")
	public ModelAndView handleNewOperatorCreation(HttpSession session,
			RedirectAttributes redirectAttributes,
			@RequestParam(name="isEditRequest",required=false) String editNewOperator){
		ModelAndView mav = null;
		if(null != editNewOperator && editNewOperator.equalsIgnoreCase("edit")){
			BusOperator operator = (BusOperator) session.getAttribute("validatedOperator");
			session.removeAttribute("validatedOperator");
			mav =  new ModelAndView(viewFolderPrefix+"operator_new");
			mav.getModelMap().put("newOperator", operator);
		}else{
			mav = new ModelAndView("redirect:/redbus/operators/");
			BusOperator newOperator = (BusOperator) session.getAttribute("validatedOperator");
			service.create(newOperator);
			redirectAttributes.addFlashAttribute("message", "New operator "+newOperator.getName()+" created successfully");
			session.removeAttribute("validatedOperator");	
		}
		return mav;
	}
	
	@PostMapping("/{id}/edit")
	public ModelAndView handleExistingOperatorUpdates(HttpSession session,
			RedirectAttributes redirectAttributes){
		ModelAndView mav = null;
		mav = new ModelAndView("redirect:/redbus/operators/");
		BusOperator newOperator = (BusOperator) session.getAttribute("validatedOperator");
		service.edit(newOperator);
		redirectAttributes.addFlashAttribute("message", "Operator "+newOperator.getName()+" edited successfully");
		session.removeAttribute("validatedOperator");
		return mav;
	}
	
}