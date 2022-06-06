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

	private String image;
	
	@NotNull(message = "vui lòng nhập giá")
	@Min(value = 0, message = "giá phải lớn hơn 0") 
	private Integer price;
	
	private Date createDate;
	
	@NotNull(message = "vui lòng nhập số lượng")
	private Integer available;
	
	@NotNull
	private Integer category;
}
