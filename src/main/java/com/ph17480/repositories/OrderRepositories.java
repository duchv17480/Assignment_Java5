package com.ph17480.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ph17480.entity.Order;

public interface OrderRepositories extends JpaRepository<Order, Integer>{

}
