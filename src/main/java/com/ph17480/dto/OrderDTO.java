package com.ph17480.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	
	private Integer id;

	private String createDate;
	
	@NotBlank(message = "vui lòng chọn địa chỉ")
	private String address;
	
	private Integer user;

}
