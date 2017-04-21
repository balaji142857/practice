package com.krishnan.balaji.practice.web.redbus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.krishnan.balaji.practice.model.a.Place;
import com.krishnan.balaji.practice.service.redbus.PlaceService;

@Controller
@RequestMapping("/redbus/places/")
public class PlaceController {

	private static final Logger log = LoggerFactory.getLogger(PlaceController.class);
	private static final String viewFolderPrefix = "redbus/common/places/";

	@Autowired
	PlaceService service;

	@GetMapping
	public ModelAndView listPlaces(@RequestParam(required = false, name = "pageNum") Integer pageNum) {
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "list");
		if (pageNum == null)
			pageNum = 0;
		mav.getModelMap().put("places", service.list(pageNum));
		return mav;
	}
	
	@GetMapping("list")
	public ModelAndView listPlaces(){
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "list");
		mav.getModelMap().put("places", service.listAll());
		return mav;
	}

	@GetMapping("new")
	public ModelAndView serveNewRequest() {
		ModelAndView mav = new ModelAndView(viewFolderPrefix + "new");
		mav.getModelMap().put("newPlace", new Place());
		return mav;
	};

	@PostMapping("confirm")
	public ModelAndView validateNewRequest(@Valid Place place, BindingResult result, HttpSession session) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			mav = new ModelAndView(viewFolderPrefix + "new");
			mav.getModelMap().put("newPlace", place);
		} else {
			mav = new ModelAndView(viewFolderPrefix + "confirm");
			mav.getModelMap().put("validatedPlace", place);
			session.setAttribute("validatedPlace", place);
		}
		return mav;
	};

	@PostMapping("new")
	public ModelAndView handleNewRequest(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(required = false, name = "edit") String editRequest) {
		ModelAndView mav = null;
		if (null == editRequest) {
			mav = new ModelAndView("redirect:/redbus/places/");
			Place place = (Place) session.getAttribute("validatedPlace");
			service.create(place);
			session.removeAttribute("validatedPlace");
		}
		return mav;
	};

	@GetMapping("{id}/edit")
	public ModelAndView serveEditRequest(@PathVariable long id) {
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"new");
		Place place = service.get(id);
		mav.getModelMap().put("newPlace", place);
		mav.getModelMap().put("editExisting", true);
		return mav;
	};

	@PostMapping("{id}/edit")
	public ModelAndView handleEditRequest(HttpSession session,
			RedirectAttributes redirectAttribute) {
		ModelAndView mav = null;
		Place place = (Place) session.getAttribute("validatedPlace");
		service.update(place);
		session.removeAttribute("validatedPlace");
		mav = new ModelAndView("redirect:/redbus/places/");
		redirectAttribute.addFlashAttribute("message", "Place "+place.getLocation()+"("+place.getPincode()+") edited successfully");
		return mav;
	};

}
