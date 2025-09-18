package com.ecommerce.sportscenter.repository;

import org.springframework.data.domain.Pageable; // THIS IS THE CORRECT ONE

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportscenter.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findAll(Pageable pageable, Specification<Product>spec);
	
	Specification<Product>searchByNameContaining(String keyword);
	
	Specification<Product>findByBrandId(Integer brandId);
	
	Specification<Product>findByTypeId(Integer typeId);
	
	Specification<Product>findByBrandAndType(Integer brandId, Integer typeId);


}
