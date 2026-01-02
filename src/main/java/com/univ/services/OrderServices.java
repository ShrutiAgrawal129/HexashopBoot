package com.univ.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.bean.Order;
import com.univ.repository.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepo;
	
	public void saveOrder(Order order) {
		orderRepo.save(order);
	}
	
	public List<Order> showOrders(){
		return orderRepo.findAll();
	}
}
