package com.example.demo5.repositories;

import com.example.demo5.domain.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestaoRepositoryJPA extends JpaRepository<Sugestao, Long> {
}
