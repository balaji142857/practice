package com.krishnan.balaji.practice.web;

import java.time.LocalDateTime;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.krishnan.balaji.practice.model.Role;
import com.krishnan.balaji.practice.model.User;
import com.krishnan.balaji.practice.service.RoleService;
import com.krishnan.balaji.practice.service.UserInfoService;

@Controller
@RequestMapping("/users")
public class UserController {

	
	private static final String folderPrefix="users/";
	@Autowired
	private UserInfoService service;
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("newUser")
	public User user(){
		return new  User();
	}
	
	@ModelAttribute("availableRoles")
	public Set<Role> roles(){
		return roleService.get();
	}
		
	@RequestMapping(value={"/"})
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView(folderPrefix+"list");
		Set<User> users = service.get();
		mav.getModel().put("usersList", users);
		return mav;
	}
	
	@RequestMapping("/new")
	public String serveNewUserForm(){
		return folderPrefix+"new";
	}
	
	@RequestMapping(value="/confirm",method=RequestMethod.POST)
	public ModelAndView reviewNewUser(User user,HttpSession session){
		ModelAndView mav = new ModelAndView(folderPrefix+"confirm");
		//TODO encrypt/hash before loading to session
		session.setAttribute("password", user.getPassword());
		session.setAttribute("user_roles", user.getAuthorities());
		user.getAuthorities().forEach(v -> System.out.print(v+" "));
		mav.getModel().put("newUserReview", user);
		
		return mav;
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ModelAndView createNewUser(User user,RedirectAttributes redirectAttributes,HttpSession session){
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		user.setPassword((String) session.getAttribute("password"));
		System.out.println("password from session is "+user.getPassword());
		user.setAuthorities((Set<Role>) session.getAttribute("user_roles"));
		session.removeAttribute("password");
		session.removeAttribute("user_roles");
		setDefaults(user);
		
		service.create(user);
		//TODO get the message from resource bundle , locale basedd
		redirectAttributes.addFlashAttribute("message", "User added");
		return mav;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView viewUserInfo(@PathVariable long id){
		ModelAndView mav = new ModelAndView(folderPrefix+"viewUserInfo");
		mav.getModelMap().put("user", service.getById(id));
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView serveEditRequest(@PathVariable long id){
		ModelAndView mav = new ModelAndView(folderPrefix+"editUserInfo");
		User user = service.getById(id);
		mav.getModelMap().put("userToEdit", user);
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.POST)
	public ModelAndView editUserInfo(User editedUser,@PathVariable long id, RedirectAttributes redirectAttr){
		System.out.println("In editUserInfo");
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		redirectAttr.addFlashAttribute("message", "User edited successfuly");
		//TODO this logic belongs in the service layer, not web
		if(null != SecurityContextHolder.getContext().getAuthentication()){
			if(null != SecurityContextHolder.getContext().getAuthentication().getPrincipal() && 
					SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
				editedUser.setCreatedBy(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
			}
			else
				editedUser.setCreatedBy("guest");
		}	
		editedUser.setUpdatedOn(LocalDateTime.now());
		service.update(editedUser);
		//mav.getModelMap().put("user", user);
		redirectAttr.addFlashAttribute("user",id);
		return mav;
	}
	
	private void setDefaults(User user) {
		if(null != user ){
			user.setAccountExpired(false);
			user.setCredentialsExpired(false);
			user.setAccountLocked(true);
			//TODO move the auditing info to service layer
			user.setEnabled(true);
			if(null != SecurityContextHolder.getContext().getAuthentication()){
				if(null != SecurityContextHolder.getContext().getAuthentication().getPrincipal() && 
						SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
					user.setCreatedBy(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
				}
				else
					user.setCreatedBy("guest");
			}
			user.setCreatedOn(LocalDateTime.now());
		}
	}
}