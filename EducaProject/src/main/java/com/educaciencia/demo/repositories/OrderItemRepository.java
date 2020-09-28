package com.educaciencia.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educaciencia.demo.entities.OrderItem;

//instanciando repositorio para trabalhar com os usuarios
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
