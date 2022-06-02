package com.ph17480.dto;

import javax.persistence.Column;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Integer id;

	private Integer quantity;

	private Integer price;
	
	private Integer order_id;
	
	private Integer product_id;
}
