package com.schms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schms.domain.Event;
import com.schms.service.CourseService;
import com.schms.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/list")
	public String events(Model model){
		List<Event> events = eventService.getEvents();
		model.addAttribute("events",events);
		return "events";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		
		Event event = new Event();
		model.addAttribute("event", event);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","register");
		return "add_edit_event";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("event") Event event, Model model){
			eventService.save(event);
			return "redirect:/event/list";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id){
		Event event = eventService.findById(id);
		model.addAttribute("event",event);
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("action","edit");
		return "add_edit_event";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("event") Event event,Model model){
		eventService.save(event);
		return "redirect:/event/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(Long id){
		eventService.delete(id);
		return "redirect:/event/list";
	}

}
