package com.backend.app.mouse.models.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.mouse.models.entity.Mouse;
import com.backend.app.mouse.models.service.MouseService;

@RestController
public class MouseController {
	
	@Autowired
	private MouseService service;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")
	public List<Mouse> list(){
		return service.findAll().stream().map(mouse -> {
			mouse.setPort(port);
			return mouse;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/mouse/{id}")
	public Mouse detail(@PathVariable Long id) {
		
//		boolean b1 = false;
//		if(!b1)
//			throw new RuntimeException("No se puede obtener el detalle del celular");
		return service.findById(id);
	}
	
	@DeleteMapping("/mouse/{id}")
	public ResponseEntity<Void> drop(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/mouse")
	public ResponseEntity<Mouse> add(@RequestBody Mouse instance) {
		Mouse mouse = service.save(instance);
		return new ResponseEntity<>(mouse, HttpStatus.CREATED);
	}
	
	@PutMapping("/mouse/{id}")
	public ResponseEntity<Mouse> update(@PathVariable Long id, @RequestBody Mouse instance) {
		if(service.existsById(id)){
			instance.setId(id);
			Mouse mouse = service.save(instance);
			return new ResponseEntity<>(mouse, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

