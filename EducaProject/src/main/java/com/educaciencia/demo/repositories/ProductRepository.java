package com.educaciencia.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaciencia.demo.entities.Product;

//instanciando repositorio para trabalhar com os usuarios
public interface ProductRepository extends JpaRepository<Product, Long> {

}
