package com.ph17480.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	private Integer quantity;

	@NotNull
	private Integer price;
	private Integer order_id;
	private Integer product_id;
}
