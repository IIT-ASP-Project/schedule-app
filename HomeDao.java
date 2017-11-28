package com.schms.dao;

import org.springframework.data.repository.CrudRepository;

import com.schms.domain.Home;

public interface HomeDao extends CrudRepository<Home,Long> {
	

}
