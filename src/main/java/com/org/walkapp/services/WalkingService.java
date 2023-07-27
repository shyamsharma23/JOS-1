package com.org.walkapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.walkapp.entities.Product;
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
			
			
			public Integer update(Long id, Product request) {
				Product product = pdao.findById(id).get();
				if(product != null) {
					product.setCategory(request.getCategory());
					product.setSku(request.getSku());
					product.setName(request.getName());
					product.setDescription(request.getDescription());
					product.setUnitPrice(request.getUnitPrice());
					product.setImageUrl(request.getImageUrl());
					product.setActive(request.isActive());
					product.setUnitsInStock(request.getUnitsInStock());
					
					pdao.save(product);
					return 1;
				}
				return 0;
			}

			public Product delete(Long id) {
				Product product = pdao.findById(id)
						.orElseThrow(() -> new RuntimeException("Data not found with this ID"));

				pdao.delete(product);
				return product;
			}
			
}
