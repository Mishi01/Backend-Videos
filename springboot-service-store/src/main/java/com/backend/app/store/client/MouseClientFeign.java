package com.backend.app.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.app.store.models.Mouse;


@FeignClient(name = "service-mouse")
public interface MouseClientFeign {
	
	@GetMapping("/list")
	public List<Mouse> list();
	
	@GetMapping("/mouse/{id}")
	public Mouse detail(@PathVariable Long id);
	
}
