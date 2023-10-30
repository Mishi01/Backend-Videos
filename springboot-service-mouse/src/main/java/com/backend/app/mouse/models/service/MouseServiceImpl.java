package com.backend.app.mouse.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.mouse.models.dao.MouseDao;
import com.backend.app.mouse.models.entity.Mouse;

@Service
public class MouseServiceImpl implements MouseService {
	@Autowired
	private MouseDao mouseDao;
	
	@Override
	public List<Mouse> findAll() {
		return (List<Mouse>)mouseDao.findAll();
	}

	@Override
	public Mouse findById(Long id) {
		return mouseDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		mouseDao.deleteById(id);
	}

	@Override
	public Mouse save(Mouse instance) {
		return mouseDao.save(instance);
	}

	@Override
	public boolean existsById(Long id) {
		return mouseDao.existsById(id);
	}

}
