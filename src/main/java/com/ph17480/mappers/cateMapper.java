package com.ph17480.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph17480.dto.AccountDTO;
import com.ph17480.dto.CategoryDTO;
import com.ph17480.entity.Account;
import com.ph17480.entity.Category;
@Service
public class cateMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Category convertToEntity(CategoryDTO cateDTO) {
		Category entity = modelMapper.map(cateDTO, Category.class);
		return entity;

	}

	public CategoryDTO convertToDTO(Category entity) {
		CategoryDTO userDTO = modelMapper.map(entity, CategoryDTO.class);
		return userDTO;

	}
}
