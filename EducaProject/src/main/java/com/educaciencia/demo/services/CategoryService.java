package com.educaciencia.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciencia.demo.entities.Category;
import com.educaciencia.demo.repositories.CategoryRepository;

//select
@Service
public class CategoryService {
	
	
	@Autowired
	private CategoryRepository repository;
	
	//metodo - select all
	public List<Category> findAll(){
		return repository.findAll();
	}	
	      //ts
	//Metodo - select por ID
	public Category findById(Long id) {
		Optional<Category> obj =  repository.findById(id);
		return obj.get();
		
		
	}
}
