package com.ph17480.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Integer id;
	
	@NotNull
	private Integer quantity;

	@NotNull
	private Integer price;
	private Integer order_id;
	private Integer product_id;
}
