package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schms.domain.Schedule;
import com.schms.service.CourseService;
import com.schms.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/list")
	public String Schedules(Model model){
		List<Schedule> schedules = scheduleService.getSchedules();
		model.addAttribute("schedules",schedules);
		return "schedules";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		
		Schedule schedule = new Schedule();
		model.addAttribute("schedule", schedule);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","register");
		return "add_edit_schedule";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("schedule") Schedule schedule, Model model){
			scheduleService.save(schedule);
			return "redirect:/schedule/list";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id){
		Schedule schedule = scheduleService.findById(id);
		model.addAttribute("schedule",schedule);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","edit");
		return "add_edit_schedule";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("schedule") Schedule schedule,Model model){
		scheduleService.save(schedule);
		return "redirect:/schedule/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(Long id){
		scheduleService.delete(id);
		return "redirect:/schedule/list";
	}

}
