package com.ph17480.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Integer id;
	
	@NotNull(message = "vui lòng nhập số lượng")
	@Min(value = 1, message = "số lượng phải lớn hơn 0")
	private Integer quantity;

	@NotNull(message = "vui lòng nhập giá")
	@Min(value = 1, message = "giá phải lớn hơn 0")
	private Integer price;
	
	private Integer order_id;
	private Integer product_id;
}
