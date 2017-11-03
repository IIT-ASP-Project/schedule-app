package com.schms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schms.domain.Professor;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String professors(){
		return "professors";
	}

}
