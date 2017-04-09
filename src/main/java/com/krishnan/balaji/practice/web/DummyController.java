package com.krishnan.balaji.practice.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.Dummy;
import com.krishnan.balaji.practice.service.DummyService;

@Controller
@RequestMapping("/dummy/")
public class DummyController {

	@Autowired DummyService service;
	private static final String viewFolderPrefix="dummy/";
	private static final String sessionValidatedObject="validatedDummy";
	private static final String sessionObjectToEdit="sessionObjectToEdit";
	
	private static final Logger logger = LoggerFactory
			.getLogger(DummyController.class);
	
	@GetMapping("new")
	public ModelAndView serveNewRequest(HttpSession session){
		Dummy dummy = null;
		if(session.getAttribute(sessionObjectToEdit)==null)
			dummy=new Dummy();
		else
		{
			dummy = (Dummy)session.getAttribute(sessionObjectToEdit);
			session.removeAttribute(sessionObjectToEdit);
		}
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"form_new");
		mav.getModelMap().put("modelObject", dummy);
		return mav;
	}
	
	@PostMapping("confirm")
	public ModelAndView validateAndserverCofirmationRequest(@ModelAttribute("modelObject") @Valid Dummy userValues,
			BindingResult bindingResult,
			@RequestParam("temp_someImage") CommonsMultipartFile imageFile,
			@RequestParam("temp_someFile") CommonsMultipartFile someFile,
			HttpSession session){
		ModelAndView mav = new ModelAndView();//"form_confirm"
		if (bindingResult.hasErrors()) {
			logger.info("Returning new dummy page");
			mav.setViewName(viewFolderPrefix+"form_new");
			mav.getModelMap().put("modelObject", userValues);
			return mav;
		}
		else {
				System.out.println("setting image content");
				userValues.setSomeImage(imageFile.getBytes());
			try {
				System.out.println("writing uplaoded file to disk");
				byte[] fileBytes = someFile.getBytes();				
				String dateFolder=DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now());
				String fileName = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now());
				Path path = Paths.get("/tmp/"+dateFolder+"/"+fileName);
				System.out.println("file path is "+path);
				Files.createFile(path);
				Path filePath = Files.write(path, fileBytes);
				userValues.setSomeFile(filePath.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute(sessionValidatedObject, userValues);
			mav.getModelMap().put("validatedObject", userValues);
			mav.setViewName(viewFolderPrefix+"form_confirm");
		}
		return mav;
	}
	
	//TODO redesign
	@PostMapping("edit")
	public ModelAndView edit(Dummy dummy){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"form_new");
		mav.getModelMap().put("modelObject", dummy);
		return mav;
	}
	
	@GetMapping(value={"cancel","","/"})
	public ModelAndView cancelCreation(ModelMap model){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"form_list");
		if(null != model && model.get("dummies")!=null)
			mav.addAllObjects(model);
		else
			mav.getModelMap().put("dummies", getDummyList());
		return mav;
	}
	
	@PostMapping("new")
	public ModelAndView create(HttpSession session, 
			@RequestParam(value="cancel",required=false) String cancel,
			@RequestParam(value="edit",required=false) String edit, RedirectAttributes redirectAttr){
		if(cancel!= null && cancel.equalsIgnoreCase("cancel")){
			return cancelCreation(null);
		}
		else if(edit != null && edit.equalsIgnoreCase("edit")){
			Dummy finalValue = (Dummy)session.getAttribute(sessionValidatedObject);
			session.removeAttribute(sessionValidatedObject);
			return edit(finalValue);
		}
		else{
			Dummy finalValue = (Dummy)session.getAttribute(sessionValidatedObject);
			service.create(finalValue);
			session.removeAttribute(sessionValidatedObject);
			redirectAttr.addFlashAttribute("dummies", getDummyList());
			ModelAndView mav = new ModelAndView("redirect:/dummy/");
			return mav;
		}
		
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> hobbies(){
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("jogging");hobbies.add("singing");
		hobbies.add("eating");hobbies.add("sleeping");
		hobbies.add("dancing");hobbies.add("reading");
		hobbies.add("fighting");hobbies.add("stamp collection");
		hobbies.add("gokarting");hobbies.add("coding");
		hobbies.add("idle");hobbies.add("playing");
		hobbies.add("rubiksCube");hobbies.add("sudoku");
		return hobbies;
	}
	
	@ModelAttribute("genderList")
	public List<String> genders(){
		List<String> genders = new ArrayList<String>();
		genders.add("male");
		genders.add("female");
		genders.add("neuter");
		return genders;
	}
	
	@ModelAttribute("subscriptionsList")
	public List<String> subscriptions(){
		List<String> subscriptions = new ArrayList<String>();
		subscriptions.add("daily");
		subscriptions.add("weekly");
		subscriptions.add("bi-weekly");
		subscriptions.add("monthly");
		subscriptions.add("quarterly");
		subscriptions.add("yearly");
		return subscriptions;
	}
	
	private List<Dummy> getDummyList() {
		Iterable<Dummy> dummies = service.get();
		List<Dummy> dummyList = new ArrayList<>();
		Iterator<Dummy> dummyIterator = dummies.iterator();
		while(dummyIterator.hasNext())
			dummyList.add(dummyIterator.next());
		return dummyList;
	}

}