package com.example.demo5.repositories;

import com.example.demo5.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoryJPA extends JpaRepository<Pedido, Long> {
}
