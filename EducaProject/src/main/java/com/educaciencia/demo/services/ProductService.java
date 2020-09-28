package com.educaciencia.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciencia.demo.entities.Product;
import com.educaciencia.demo.repositories.ProductRepository;

//select
@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository repository;
	
	//metodo - select all
	public List<Product> findAll(){
		return repository.findAll();
	}	
	
	//Metodo - select por ID
	public Product findById(Long id) {
		Optional<Product> obj =  repository.findById(id);
		return obj.get();
		
		
	}
}
