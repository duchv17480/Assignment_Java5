package com.ph17480.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ph17480.entity.Cart;

public interface CartRepository  extends JpaRepository<Cart, Integer>{

}
