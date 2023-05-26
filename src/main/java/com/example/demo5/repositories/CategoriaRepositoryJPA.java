package com.example.demo5.repositories;

import com.example.demo5.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositoryJPA extends JpaRepository<Categoria, Long> {
}
