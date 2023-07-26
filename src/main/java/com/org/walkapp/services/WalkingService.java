package com.org.walkapp.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.walkapp.entities.Product;
import com.org.walkapp.entities.dao.ProductCategoryDao;
import com.org.walkapp.entities.dao.ProductDao;

import jakarta.persistence.Column;


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
			
}

//class ProductRequest {
//    private String sku;
//
//    private String name;
//
//    private BigDecimal unitPrice;
//
//    private String imageUrl;
//
//    private boolean active;
//
//    private int unitsInStock;
//
//	public String getSku() {
//		return sku;
//	}
//
//	public void setSku(String sku) {
//		this.sku = sku;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public BigDecimal getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(BigDecimal unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//
//	public int getUnitsInStock() {
//		return unitsInStock;
//	}
//
//	public void setUnitsInStock(int unitsInStock) {
//		this.unitsInStock = unitsInStock;
//	}
//    
//}