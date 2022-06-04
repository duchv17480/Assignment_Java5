package com.ph17480.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph17480.dto.ProductDTO;
import com.ph17480.entity.Product;
@Service
public class ProductMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Product convertToEntity(ProductDTO accountDTO) {
		Product entity = modelMapper.map(accountDTO, Product.class);
		return entity;

	}

	public ProductDTO convertToDTO(Product entity) {
		ProductDTO userDTO = modelMapper.map(entity, ProductDTO.class);
		return userDTO;

	}
	 public <C,E> C convertEntityAndDto(final E entity, Class<C> outputClass){
	        return modelMapper.map(entity, outputClass);
	    }

}
