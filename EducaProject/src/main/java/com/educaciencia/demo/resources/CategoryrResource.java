package com.educaciencia.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaciencia.demo.entities.Category;
import com.educaciencia.demo.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryrResource {
	
	@Autowired
	private CategoryService service;
	
	//Teste em Jason localhost:8080/users
	
	//endpoint - select all
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint - select by Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
