package com.example.demo5.controllers;

import com.example.demo5.domain.Categoria;
import com.example.demo5.domain.Sugestao;
import com.example.demo5.repositories.CategoriaRepositoryJPA;
import com.example.demo5.repositories.SugestaoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sugestao")
public class SugestaoController {

    @Autowired
    private SugestaoRepositoryJPA sugestaoRepositoryJPA;

    @GetMapping
    public List<Sugestao> findAll() {
         return sugestaoRepositoryJPA.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sugestao get(@PathVariable(name = "id") Long id) {
       return sugestaoRepositoryJPA.findById(id).orElse(null);
    }

    @PostMapping
    public Sugestao create(@RequestBody Sugestao sugestao) {
        sugestao = sugestaoRepositoryJPA.save(sugestao);
        return sugestao;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Sugestao sugestao) {
        sugestao.setId(id);
        sugestaoRepositoryJPA.save(sugestao);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        sugestaoRepositoryJPA.deleteById(id);
    }



}
