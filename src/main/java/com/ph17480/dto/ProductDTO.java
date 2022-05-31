package com.ph17480.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class ProductDTO {
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String image;
	@NotNull
	private Integer price;
	@NotNull(message = "vui lòng chọn ngày")
	private Date createDate;
	@NotNull
	private Integer available;
	@NotNull
	private Integer category;
}
