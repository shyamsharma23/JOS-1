package com.org.walkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.walkapp.entities.Product;
import com.org.walkapp.entities.dao.ProductDao;
import com.org.walkapp.services.WalkingService;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	
	@Autowired
	WalkingService service;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProducts(@PathVariable("id") Long id){
		return new ResponseEntity<Product>(service.find(id), HttpStatus.OK); 
	}
	
	@PostMapping("/product/create")
    public ResponseEntity<String> create(@RequestBody Product product) {
           Product prod = service.createProduct(product);  
        return new ResponseEntity<>("product created successfully", HttpStatus.CREATED);
    }
	

}
