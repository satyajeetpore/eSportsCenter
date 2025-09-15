package com.ecommerce.sportscenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.entity.Type;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.model.TypeResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import com.ecommerce.sportscenter.repository.TypeRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService{
	private final TypeRepository typeRepository;
	
	public TypeServiceImpl(TypeRepository typeRepository ) {
		this.typeRepository = typeRepository;
	}
	
	public List<TypeResponse>getAllTypes(){
		log.info("fetching all types!! ");
		
		List<Type>typeList=typeRepository.findAll();
		
		List<TypeResponse>typeResponses = typeList.stream()
				.map(this::convertToTypeResponse)
				.collect(Collectors.toList());
		log.info("Fetched all type");
		
		return typeResponses;
		
	}
	
	private TypeResponse convertToTypeResponse(Type type) {
		// TODO Auto-generated method stub
		return TypeResponse.builder()
				.id(type.getId())
				.name(type.getName())
				.build();
	}


}
