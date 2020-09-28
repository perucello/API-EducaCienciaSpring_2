package com.educaciencia.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educaciencia.demo.entities.User;

//instanciando repositorio para trabalhar com os usuarios
public interface UserRepository extends JpaRepository<User, Long> {

}
