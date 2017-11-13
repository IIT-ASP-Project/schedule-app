package com.schms.dao;

import org.springframework.data.repository.CrudRepository;

import com.schms.domain.Course;

public interface CourseDao extends CrudRepository<Course,Long> {
	
}
