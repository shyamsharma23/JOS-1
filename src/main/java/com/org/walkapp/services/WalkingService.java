package com.org.walkapp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.walkapp.entities.Product;
import com.org.walkapp.entities.ProductCategory;
import com.org.walkapp.entities.dao.ProductCategoryDao;
import com.org.walkapp.entities.dao.ProductDao;

@Service
public class WalkingService {

	
			@Autowired
			ProductDao pdao;
			@Autowired
			ProductCategoryDao pcdao;
	
			public Product find(Long id) {
				    Product obj =  pdao.findById(id).orElseThrow(() -> new RuntimeException("Data not found with this ID"));
				    
				   return obj;
				    
			}
			
			
			public Product createProduct(Product product) {
				
				Product productone = pdao.save(product);
				return productone;
			}
			public Product update(Long id, Product request) {
				Product product = pdao.findById(id).orElseThrow(()-> new RuntimeException("Data not found"));
				
					product.setCategory(request.getCategory());
					product.setSku(request.getSku());
					product.setName(request.getName());
					product.setDescription(request.getDescription());
					product.setUnitPrice(request.getUnitPrice());
					product.setImageUrl(request.getImageUrl());
					product.setActive(request.isActive());
					product.setUnitsInStock(request.getUnitsInStock());
					
					return pdao.save(product);
					
				 
			}

			
			


	
	

	

	public List<Product> findAll(Long categoryId) throws RuntimeException, Exception {
		List<Product> listOfProduct = pdao.findByCategoryId(categoryId);
		return listOfProduct;

	}

	

	public Product delete(Long id) {
		Product product = pdao.findById(id)
				.orElseThrow(() -> new RuntimeException("Data not found with this ID"));

		pdao.delete(product);
		return product;
	}


}
