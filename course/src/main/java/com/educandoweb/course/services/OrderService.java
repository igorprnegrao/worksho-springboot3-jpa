package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	};
	
	public Order findByOrder(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	} 
	
	
	
}
