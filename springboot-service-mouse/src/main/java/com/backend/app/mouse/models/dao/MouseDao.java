package com.backend.app.mouse.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.app.mouse.models.entity.Mouse;

public interface MouseDao extends CrudRepository<Mouse, Long>{
	
}
