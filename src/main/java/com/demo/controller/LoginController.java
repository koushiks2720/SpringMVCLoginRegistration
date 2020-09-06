package com.demo.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Login;
import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class LoginController {
	 @Autowired
		public UserService userservice;
		
		@RequestMapping(value="/login",method=RequestMethod.GET)
		public ModelAndView login(HttpServletRequest req,HttpServletResponse res)
		{
			ModelAndView mav=new ModelAndView("login");
			mav.addObject("login",new Login());
			return mav;
		}
		@RequestMapping(value="/log",method=RequestMethod.POST)
		public ModelAndView loginPro(HttpServletRequest req,HttpServletResponse res,@ModelAttribute("login")Login login)
		{
			ModelAndView mav=null;
			User user=userservice.validateUser(login);
			if(null != user)
			{
				mav=new ModelAndView("welcome");
				mav.addObject("firstname", user.getFirstname());
			}
			else {
				mav=new ModelAndView("login");
				mav.addObject("message", "Username and password is wrong !!");
			}
			return mav;
		}
}
