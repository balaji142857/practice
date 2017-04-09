package com.krishnan.balaji.practice.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/roles")
public class RolesController {

	private static final String folderPrefix="roles/";
	
	@Autowired
	RoleService service;
	
	@ModelAttribute("newRole")
	public Role role(){
		return new Role();
	}
	
	/**
	 * endpoint to list out the existing roles
	 * @return 
	 */
	@RequestMapping(value={"/"})
	public ModelAndView listRoles(){
		ModelAndView mav = new ModelAndView(folderPrefix+"list");
		mav.getModel().put("availableRoles", service.get());
		return mav;
	}

	/**
	 * Endpoint to list out users in a particular role
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView showRoleAndUsers(@PathVariable long id){
		ModelAndView mav = new ModelAndView(folderPrefix+"edit");
		Role role = service.get(id);
		Set<User> users = service.get(role.getId()).getUsers();
		mav.getModel().put("usersInRole", users);
		mav.getModel().put("editRole", role);
		return mav;
	}
	
	/**
	 * Endpoint for requesting a new role 
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String serveNewRoleRequest(){
		return folderPrefix+"new";
	}

	/**
	 * Endpoint to reivew a new role being added
	 * @param role
	 * @return
	 */
	@RequestMapping(value="confirm",method=RequestMethod.POST)
	public ModelAndView reviewNewRole(Role role){
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("newRoleReview", role);
		return mav;
	}
	
	/**
	 * Endpoint to POST for adding a reviewed role
	 * @param role
	 * @param redirectAttr
	 * @return
	 */
	@RequestMapping(value="new",method=RequestMethod.POST)
	public ModelAndView createNewRole(Role role,RedirectAttributes redirectAttr){
		service.create(role);
		redirectAttr.addFlashAttribute("message","Role "+role.getName()+" created");
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		return mav;
	}

	/**
	 * Endpoint to edit an existing role
	 * @return
	 */
	@RequestMapping(value="/{id}/edit",method=RequestMethod.POST)
	public ModelAndView editExistingRole(Role role,RedirectAttributes redirectAttr,@PathVariable long id){
		System.out.println("update "+role.getId()+":"+role.getName()+", value from path is "+id);
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		//try {
			service.update(role);
		/*} catch (NoSuchRoleException e) {
			e.printStackTrace();
			redirectAttr.addFlashAttribute("message", "No such role exists!");
			return mav;
		}*/
		redirectAttr.addFlashAttribute("message", "Role was updated successfully");
		return mav;
	}
	
	//TODO why http delete not supported by chrome browser
	@RequestMapping(value="/{id}/delete",method=RequestMethod.POST)
	public ModelAndView deleteRole(Role role,RedirectAttributes redirectAttr){
		ModelAndView mav = new ModelAndView("redirect:/"+folderPrefix);
		//try {
			service.delete(role);
			redirectAttr.addFlashAttribute("message", role.getName()+" was deleted successfully");
		/*} catch (NoSuchRoleException e) {
			redirectAttr.addFlashAttribute("message", role.getName()+" was not found to delete");
			e.printStackTrace();
		}*/
		return mav;
	}
	
	
}