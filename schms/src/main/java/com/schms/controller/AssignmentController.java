package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.schms.domain.Assignment;
import com.schms.service.AssignmentService;
import com.schms.service.CourseService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value="/list")
	public String assignments(Model model){
		List<Assignment> Assignments = assignmentService.getAssignments();
		model.addAttribute("assignments",Assignments);
		return "assignments";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		
		Assignment Assignment = new Assignment();
		model.addAttribute("assignment", Assignment);
		model.addAttribute("action","register");
		model.addAttribute("courses",courseService.getCourses());
		return "add_edit_assignment";
	}

	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register( @ModelAttribute("Assignment") Assignment assignment, Model model){
		assignmentService.save(assignment);
		return "redirect:/assignment/list";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id){
		Assignment assignment = assignmentService.findById(id);
		
		model.addAttribute("assignment",assignment);
		model.addAttribute("action","edit");
		model.addAttribute("courses",courseService.getCourses());
		return "add_edit_assignment";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("assignment") Assignment assignment,Model model){
		assignmentService.save(assignment);
		return "redirect:/assignment/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(Long id){
		assignmentService.delete(id);
		return "redirect:/assignment/list";
	}
}
