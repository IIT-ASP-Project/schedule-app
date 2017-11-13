package com.schms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(){
		return "redirect:/course/list";
	}
	
//	@RequestMapping("/home")
//	public String home(){
//		return "redirect:/course/list";
//	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
}
