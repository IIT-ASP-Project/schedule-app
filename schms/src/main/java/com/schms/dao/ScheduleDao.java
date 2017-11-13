package com.schms.dao;

import org.springframework.data.repository.CrudRepository;

import com.schms.domain.Schedule;

public interface ScheduleDao extends CrudRepository<Schedule,Long> {

}
