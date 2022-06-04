package com.ph17480.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
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
	private Integer id;
	
	@NotBlank(message = "vui lòng nhập tên sản phẩm")
	private String name;

	@NotNull
	@NotBlank(message = "vui lòng chọn ảnh")
	private String image;
	
	@NotNull
	@Min(value = 0) 
	private Integer price;
	
	@NotNull
	private Date createDate;
	
	@NotNull
	private Integer available;
	
	@NotNull
	private Integer category;
}
