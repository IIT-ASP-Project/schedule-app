package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schms.domain.Course;
import com.schms.domain.Professor;
import com.schms.domain.Schedule;
import com.schms.service.CourseService;
import com.schms.service.ProfessorService;


@Controller
@RequestMapping("/course")
public class CourseController {
	
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ProfessorService professorService;
	
	@RequestMapping(value="/list",  method = RequestMethod.GET)
	public String professors(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		List<Course> professors = courseService.getCourses();
		model.addAttribute("courses",professors);
		return "courses";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		Course course = new Course();
		List<Professor> professors = professorService.getProfessors();		
		System.out.println(professors);
		model.addAttribute("course", course);
		model.addAttribute("action","register");
		model.addAttribute("professors", professors);
		return "add_edit_course";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("course") Course course, Model model){
			courseService.save(course);		
			return "redirect:/course/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model,  @RequestParam("id") Long id){
		Course course = courseService.findById(id);
		model.addAttribute("professors", professorService.getProfessors());
		model.addAttribute("course",course);
		model.addAttribute("action","edit");
		return "add_edit_course";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("course") Course course,Model model){
		courseService.save(course);
		return "redirect:/course/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(Long id){
		courseService.delete(id);
		return "redirect:/course/list";
	}
	
	

}
