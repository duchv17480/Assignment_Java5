package com.ph17480.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	private Integer id;
	
	private String name;
	
	private String image;

	private int price;
	
	private Integer available;
	
}
