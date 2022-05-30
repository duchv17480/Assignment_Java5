package com.ph17480.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoryDTO {
	private Integer categoryID;
	private String categoryName;

}
