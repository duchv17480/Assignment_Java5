package com.ph17480.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph17480.dto.OrderDetailDTO;
import com.ph17480.entity.OrderDetail;

@Service
public class OrderDetailMapper {
	@Autowired
	private ModelMapper modelMapper;

	public OrderDetail convertToEntity(OrderDetailDTO orderDTO) {
		OrderDetail entity = modelMapper.map(orderDTO, OrderDetail.class);
		return entity;

	}

	public OrderDetailDTO convertToDTO(OrderDetail entity) {
		OrderDetailDTO orderDTO = modelMapper.map(entity, OrderDetailDTO.class);
		return orderDTO;

	}
}
