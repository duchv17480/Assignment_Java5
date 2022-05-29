package com.ph17480.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph17480.dto.AccountDTO;
import com.ph17480.entity.Account;


@Service
public class AccountMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Account convertToEntity(AccountDTO accountDTO) {
		Account entity = modelMapper.map(accountDTO, Account.class);
		return entity;

	}

	public AccountDTO convertToDTO(Account entity) {
		AccountDTO userDTO = modelMapper.map(entity, AccountDTO.class);
		return userDTO;

	}
}
