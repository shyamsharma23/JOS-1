package com.org.walkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.org.walkapp.entities.Product;
import com.org.walkapp.services.WalkingService;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	// Product controller 
	@Autowired
	private WalkingService service;
	// product id is not serialize
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProducts(@PathVariable("id") Long id){
		
		
		return new ResponseEntity<Product>(service.find(id), HttpStatus.OK); 
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Integer> udpateProduct(@PathVariable("id") Long id, @RequestBody Product request) {
		
		return new ResponseEntity<Integer>(service.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
