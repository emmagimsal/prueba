package com.utn.main.controllers;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.main.dtos.DTOBase;
import com.utn.main.services.IBaseService;

public abstract class BaseController <DTOBase> {
	
	private IBaseService<DTOBase> service;
	
	public BaseController(IBaseService<DTOBase> service) {
		this.service = service;
	}

	@Transactional
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(200).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(404).body("{\"message\": \"Error. Please try again later.\"}");
		}
	}

	@Transactional
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity getOne(int id) {
		try {
			return ResponseEntity.status(200).body(service.findById(id));
		} catch (Exception e) {
		return ResponseEntity.status(404).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
		
	}
	@Transactional
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity post(@RequestBody DTOBase t) {
		
		try {
			DTOBase dto = (DTOBase) service.save(t);
			return ResponseEntity.status(201).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}

	@Transactional
	@PutMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity put(@PathVariable int id, @RequestBody DTOBase t) {
		try {
			DTOBase dto = (DTOBase) service.save(t);
			return ResponseEntity.status(201).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
	}
	
	@Transactional
	@DeleteMapping("/")
	@CrossOrigin("*")
	public ResponseEntity delete(int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(204).body("{\"message\": \"Delete Successful.\"}");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
	}

	public IBaseService<DTOBase> getService() {
		return service;
	}

	public void setService(IBaseService<DTOBase> service) {
		this.service = service;
	}

}
