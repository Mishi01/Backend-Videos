package com.backend.app.mouse.models.service;

import java.util.List;

import com.backend.app.mouse.models.entity.Mouse;

public interface MouseService {
	
	public List<Mouse> findAll();
	
	public Mouse findById(Long id);
	
	public void deleteById(Long id);
	
	public Mouse save(Mouse instance);
	
	public boolean existsById(Long id);
}	