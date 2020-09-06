package com.demo.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
	public UserService userservice;
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mav=new ModelAndView("register");
		mav.addObject("user",new User());
		return mav;
	}
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req,HttpServletResponse res ,@ModelAttribute("user")User user)
	{
		
		userservice.register(user);
		return new ModelAndView("welcome","firstname", user.getFirstname());
	}
}
 