package com.org.walkapp.services;

import java.util.List;
import java.util.Optional;

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
			
//			public List<Product> findByCategoryId(Long id) {
//			    // find it by category id
//		    }
			
			
}