package com.ph17480.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoryDTO {
	private Integer id;
	@NotNull
	@NotBlank(message = "vui long nhap ")
	private String name;

}
