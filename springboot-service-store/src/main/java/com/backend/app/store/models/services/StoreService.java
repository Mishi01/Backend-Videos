package com.backend.app.store.models.services;

import java.util.List;

import com.backend.app.store.models.Store;

public interface StoreService {

	public List<Store> findAll();
	public Store findById(Long id, Integer cantidad);
}
