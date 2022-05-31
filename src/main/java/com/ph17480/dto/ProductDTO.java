package com.ph17480.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	@NotNull
	@NotBlank
	private String name;

	private String image;
	
	private MultipartFile imageFile;
	@NotNull
	private Integer price;
	@NotNull(message = "vui lòng chọn ngày")
	private Date createDate;
	@NotNull
	private Integer available;
	@NotNull
	private Integer category;
}
