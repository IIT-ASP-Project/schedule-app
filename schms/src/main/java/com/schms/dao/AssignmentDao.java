package com.schms.dao;

import org.springframework.data.repository.CrudRepository;

import com.schms.domain.Assignment;

public interface AssignmentDao extends CrudRepository<Assignment,Long> {
	

}
