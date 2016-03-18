package com.guogee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guogee.bean.User;

@Controller
public class UserController {
	
	@RequestMapping("showUser.do")
	public ModelAndView showUser(ModelMap model,HttpServletRequest request){
		User user=new User("KE", 12, "ShenZhen");
		model.put("user", user);
		return new ModelAndView("index", model);
	}
	

}
