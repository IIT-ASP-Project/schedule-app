package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schms.domain.Assignment;
import com.schms.domain.Event;
import com.schms.domain.Schedule;
import com.schms.service.AssignmentService;
import com.schms.service.EventService;
import com.schms.service.ScheduleService;



@Controller
public class HomeController {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("/")
	public String index(){
		return "redirect:/course/list";
	}
	
	@RequestMapping(value="/list")
	public String events(Model model){
		List<Assignment> Assignments = assignmentService.getAssignments();
		model.addAttribute("assignments",Assignments);
		List<Event> events = eventService.getEvents();
		model.addAttribute("events",events);
		List<Schedule> schedules = scheduleService.getSchedules();
		model.addAttribute("schedules",schedules);
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
