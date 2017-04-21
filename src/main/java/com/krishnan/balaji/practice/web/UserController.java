package com.krishnan.balaji.practice.web;

import java.time.LocalDateTime;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
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
		log.debug("servicing request for users/");
		ModelAndView mav = new ModelAndView(folderPrefix+"list");
		log.debug("delegating to  service layer");
		Set<User> users = service.get();
		log.debug("got the users set from service layer : "+users);
		mav.getModel().put("usersList", users);
		return mav;
	}
	
	@RequestMapping("/new")
	public String serveNewUserForm(){
		return folderPrefix+"new";
	}
	
	//TODO use logger everywhere
	//TODO use all messages from resource bundle
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
		redirectAttributes.addFlashAttribute("message", "User "+ user.getUsername() +" added successfully");
		return mav;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView viewUserInfo(@PathVariable long id){
		ModelAndView mav = new ModelAndView(folderPrefix+"viewUserInfo");
		User user = service.getById(id);
		mav.getModelMap().put("user", user);
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView serveEditRequest(@PathVariable long id,HttpSession session){
		ModelAndView mav = new ModelAndView(folderPrefix+"editUserInfo");
		User user = service.getById(id);
		session.setAttribute("userToEdit",user);
		mav.getModelMap().put("userToEdit", user);
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.POST)
	public ModelAndView editUserInfo(User editedUser,@PathVariable long id, 
			RedirectAttributes redirectAttr,
			HttpSession session){
		log.debug("In editUserInfo");
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		//TODO this logic belongs in the service layer, not web
		User repoUser = (User) session.getAttribute("userToEdit");
		repoUser.setUsername(editedUser.getUsername());
		repoUser.setEmail(editedUser.getEmail());
		repoUser.setFirstName(editedUser.getFirstName());
		repoUser.setLastName(editedUser.getLastName());
		repoUser.setAuthorities(editedUser.getAuthorities());
		if(null != SecurityContextHolder.getContext().getAuthentication()){
			if(null != SecurityContextHolder.getContext().getAuthentication().getPrincipal() && 
					SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
				repoUser.setUpdatedBy(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
			}
			else
				repoUser.setUpdatedBy("guest");
		}	
		repoUser.setUpdatedOn(LocalDateTime.now());
		service.update(repoUser);
		redirectAttr.addFlashAttribute("message", "User " + repoUser.getUsername() + " edited successfuly");
		redirectAttr.addFlashAttribute("user",id);
		return mav;
	}
	
	

	private void setDefaults(User user) {
		if(null != user ){
			user.setAccountExpired(false);
			user.setCredentialsExpired(false);
			user.setAccountLocked(false);
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