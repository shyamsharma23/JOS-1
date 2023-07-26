package com.org.walkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.walkapp.entities.Product;
import com.org.walkapp.services.WalkingService;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	// Product controller 
	@Autowired
	private WalkingService service;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProducts(@PathVariable("id") Long id){
		
		
		return new ResponseEntity<Product>(service.find(id), HttpStatus.OK); 
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Integer> udpateProduct(@PathVariable("id") Long id, @RequestBody Product request) {
		
		return new ResponseEntity<Integer>(service.update(id, request), HttpStatus.OK);
	}

}
