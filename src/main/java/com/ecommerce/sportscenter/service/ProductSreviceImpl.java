package com.ecommerce.sportscenter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductSreviceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductSreviceImpl(ProductRepository productRepository ) {
		this.productRepository = productRepository;
	}
	@Override
	public ProductResponse getProductById(Integer productId) {
		// TODO Auto-generated method stub
		log.info("fetching Product By Id: {}", productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new RuntimeException("Product with given id does not exists"));
		//convert the product to product response
		ProductResponse productResponse = convertToProductResponse(product);
		log.info("Fetched Product by Product Id: {}", productId);
		return productResponse;
	}

	private ProductResponse convertToProductResponse(Product product) {
		// TODO Auto-generated method stub
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.pictureUrl(product.getPictureUrl())
				.productBrand(product.getBrand().getName())
				.productType(product.getType().getName())
				.build();
	}
	@Override
	public List<ProductResponse> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
