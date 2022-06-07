package com.ph17480.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.ph17480.entity.OrderDetail;

public interface OrderDetailRepositories extends JpaRepository<OrderDetail, Integer>{
	@Query("Select entity From OrderDetail entity Where entity.order.id = :id")
	public List<OrderDetail> findOrder(@Param("id")Integer id);
}
