package com.educaciencia.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaciencia.demo.entities.Category;

//instanciando repositorio para trabalhar com os usuarios
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
