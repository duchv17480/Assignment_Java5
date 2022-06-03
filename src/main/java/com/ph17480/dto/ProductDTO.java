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
	@NotNull
	@NotBlank(message = "vui long nhap ho ten")
	private String name;

//	@NotNull
//	@NotBlank
	private String image;
	
	@NotNull
	@Min(value = 0, message = "price phải lớn hơn 0") 
	private Integer price;
	
	@NotNull(message = "vui lòng chọn ngày")
	private Date createDate;
	
	@NotNull(message = "vui long nhap so luong")
	private Integer available;
	
	@NotNull
	private Integer category;
}
