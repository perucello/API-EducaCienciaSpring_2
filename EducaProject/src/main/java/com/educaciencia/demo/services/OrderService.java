package com.educaciencia.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciencia.demo.entities.Order;
import com.educaciencia.demo.repositories.OrderRepository;

//select
@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository repository;
	
	//metodo - select all
	public List<Order> findAll(){
		return repository.findAll();
	}	
	
	//Metodo - select por ID
	public Order findById(Long id) {
		Optional<Order> obj =  repository.findById(id);
		return obj.get();
		
		
	}
}
