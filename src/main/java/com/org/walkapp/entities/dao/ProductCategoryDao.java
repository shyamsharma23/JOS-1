package com.org.walkapp.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.walkapp.entities.ProductCategory;


@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Long> {

}