package com.ecommerce.sportscenter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sportscenter.model.BrandResponse;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.model.TypeResponse;
import com.ecommerce.sportscenter.service.BrandService;
import com.ecommerce.sportscenter.service.ProductService;
import com.ecommerce.sportscenter.service.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;
	
	private final TypeService typeService;
	
	private final BrandService brandService;
	
	public ProductController(ProductService productService, BrandService brandService, TypeService typeService) {
		this.typeService = typeService;
		this.brandService = brandService;
		this.productService = productService;	
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id")Integer productId){
		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductResponse>> getProducts(){
		List<ProductResponse> productResponses =productService.getProducts();
		return new ResponseEntity<>(productResponses, HttpStatus.OK);
		
	}
	
	@GetMapping("/brands")
	public ResponseEntity<List<BrandResponse>>getBrands(){
		List<BrandResponse>brandReponses = brandService.getAllBrands();
		return new ResponseEntity<>(brandReponses, HttpStatus.OK);
	}
	
	@GetMapping("/types")
	public ResponseEntity<List<TypeResponse>>getResponses(){
		List<TypeResponse>typeResponses = typeService.getAllTypes();
		return new ResponseEntity<>(typeResponses, HttpStatus.OK);
	}
	
	
}
