package com.ph17480.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph17480.dto.OrderDTO;
import com.ph17480.entity.Order;
@Service
public class OrderMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Order convertToEntity(OrderDTO orderDTO) {
		Order entity = modelMapper.map(orderDTO, Order.class);
		return entity;

	}

	public OrderDTO convertToDTO(Order entity) {
		OrderDTO orderDTO = modelMapper.map(entity, OrderDTO.class);
		return orderDTO;

	}
}
