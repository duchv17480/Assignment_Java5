package com.ph17480.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ph17480.entity.Product;

public interface ProductRepositories extends JpaRepository<Product, Integer>{

}
