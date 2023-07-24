package com.org.walkapp.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.walkapp.entities.Product;


@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
		
}
