package com.example.demo5.repositories;

import com.example.demo5.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);
}
