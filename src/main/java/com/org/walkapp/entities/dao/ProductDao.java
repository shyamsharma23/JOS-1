package com.org.walkapp.entities.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.org.walkapp.entities.Product;
import com.org.walkapp.entities.ProductCategory;


@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

	 

	
	@Query(value = "SELECT * FROM product where category_id =?1", nativeQuery = true)
	public List<Product> findByCategoryId(Long id) throws Exception;
	
	@Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

}
