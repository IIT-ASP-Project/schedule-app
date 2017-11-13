package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schms.domain.TeachingAssistant;
import com.schms.service.CourseService;
import com.schms.service.TeachingAssistantService;

@Controller
@RequestMapping("/teachingAssistant")
public class TeachingAssistantController {
	
	@Autowired
	private TeachingAssistantService teachingAssistantService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/list")
	public String teachingAssistants(Model model){
		List<TeachingAssistant> teachingAssistants = teachingAssistantService.getTeachingAssistants();
		model.addAttribute("teachingAssistants",teachingAssistants);
		return "teachingAssistants";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		
		TeachingAssistant teachingAssistant = new TeachingAssistant();
		model.addAttribute("teachingAssistant", teachingAssistant);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","register");
		return "add_edit_teachingAssistant";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("teachingAssistant") TeachingAssistant teachingAssistant, Model model){
			teachingAssistantService.save(teachingAssistant);
			return "redirect:/teachingAssistant/list";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id){
		TeachingAssistant teachingAssistant = teachingAssistantService.findById(id);
		model.addAttribute("teachingAssistant",teachingAssistant);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","edit");
		return "add_edit_teachingAssistant";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("teachingAssistant") TeachingAssistant teachingAssistant,Model model){
		teachingAssistantService.save(teachingAssistant);
		return "redirect:/teachingAssistant/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(Long id){
		teachingAssistantService.delete(id);
		return "redirect:/teachingAssistant/list";
	}

}
