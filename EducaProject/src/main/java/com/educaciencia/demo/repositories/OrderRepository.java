package com.educaciencia.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaciencia.demo.entities.Order;

//instanciando repositorio para trabalhar com os usuarios
public interface OrderRepository extends JpaRepository<Order, Long> {

}
