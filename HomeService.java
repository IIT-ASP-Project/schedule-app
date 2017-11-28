package com.schms.service;

import java.util.List;

import com.schms.domain.Assignment;
import com.schms.domain.Event;
import com.schms.domain.Home;
import com.schms.domain.Schedule;

public interface HomeService {
	
	List<Assignment> getAssignments();

	List<Event> getEvents();
	
	List<Schedule> getSchedules();
	

}