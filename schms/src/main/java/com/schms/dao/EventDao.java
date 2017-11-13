package com.schms.dao;

import org.springframework.data.repository.CrudRepository;

import com.schms.domain.Event;

public interface EventDao extends CrudRepository<Event,Long> {

}
