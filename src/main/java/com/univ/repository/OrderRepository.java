package com.univ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univ.bean.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}