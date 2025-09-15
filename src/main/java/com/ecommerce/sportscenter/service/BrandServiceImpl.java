package com.ecommerce.sportscenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.sportscenter.entity.Brand;
import com.ecommerce.sportscenter.model.BrandResponse;
import com.ecommerce.sportscenter.repository.BrandRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{
	private final BrandRepository brandRepository;
	
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository= brandRepository;
	}
	
	@Override
	public List<BrandResponse> getAllBrands() {
		// TODO Auto-generated method stub
		//fetch brand
		List<Brand>brandList = brandRepository.findAll();
		//now use stream operator to map with response
		List<BrandResponse> brandResponses = brandList.stream()
				.map(this::convertToBrandResponse).collect(Collectors.toList());
		
		log.info("fetched all brands");
		
		
		return brandResponses;
	}
		
		private BrandResponse convertToBrandResponse(Brand brand) {
		    return BrandResponse.builder()
		            .id(brand.getId())
		            .name(brand.getName())
		            .build();
		}

	}


