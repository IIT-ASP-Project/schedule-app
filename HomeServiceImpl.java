package com.schms.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schms.dao.HomeDao;
import com.schms.dao.ScheduleDao;
import com.schms.domain.Home;
import com.schms.domain.Schedule;
import com.schms.service.HomeService;
import com.schms.dao.AssignmentDao;
import com.schms.dao.EventDao;
import com.schms.domain.Assignment;
import com.schms.domain.Event;
import com.schms.service.AssignmentService;
import com.schms.service.EventService;


@Service
public class HomeServiceImpl implements HomeService {
	
	
	@Autowired
	AssignmentDao assignmentDao;
	
	@Autowired
	EventDao eventDao;
	
	@Autowired
	ScheduleDao scheduleDao;

	@Override
	public List<Assignment> getAssignments() {
		return (List<Assignment>)assignmentDao.findAll();
	}
	
	@Override
	public List<Event> getEvents() {
		return (List<Event>)eventDao.findAll();
	}
	
	
	@Override
	public List<Schedule> getSchedules() {
		return (List<Schedule>)scheduleDao.findAll();
	}
	
	
	

}
