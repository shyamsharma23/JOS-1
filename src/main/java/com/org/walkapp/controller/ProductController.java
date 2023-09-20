package com.org.walkapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.org.walkapp.entities.Product;
import com.org.walkapp.entities.ProductCategory;
import com.org.walkapp.entities.dao.ProductDao;
import com.org.walkapp.services.WalkingService;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class ProductController {

	@Autowired
	private WalkingService service;

	@GetMapping("/category")
	public ResponseEntity<List<ProductCategory>> getAllCategory() {
		return new ResponseEntity<List<ProductCategory>>(service.findCategoryList(), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity(service.findAllProducts(), HttpStatus.OK);
	}
	// My comment
	// My another comment

	@GetMapping("/product/{id}") // Controller for recieving get request
	public ResponseEntity<Product> getProducts(@PathVariable("id") Long id) {
		return new ResponseEntity<Product>(service.find(id), HttpStatus.OK);
	}

	@PostMapping("/product/create")
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product prod = service.createProduct(product);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}

	// Product controller
	// Added for jenkins purpose

	@GetMapping("/products/{categoryId}")
	public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId)
			throws RuntimeException, Exception {
		return new ResponseEntity<List<Product>>(service.findAll(categoryId), HttpStatus.OK);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> udpateProduct(@PathVariable("id") Long id, @RequestBody Product request) {

		return new ResponseEntity<Product>(service.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
