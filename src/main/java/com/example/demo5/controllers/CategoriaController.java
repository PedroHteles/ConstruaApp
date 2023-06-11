package com.example.demo5.controllers;

import com.example.demo5.domain.Categoria;
import com.example.demo5.repositories.CategoriaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepositoryJPA categoriaRepositoryJPA;

    @GetMapping
    public List<Categoria> findAll() {
         return categoriaRepositoryJPA.findAll();
    }

    @GetMapping(value = "/{id}")
    public Categoria get(@PathVariable(name = "id") Long id) {
       return categoriaRepositoryJPA.findById(id).orElse(null);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        if(categoria.getNome() != null){
            categoria = categoriaRepositoryJPA.save(categoria);
        }
        return categoria;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Categoria categoria) {
        categoria.setId(id);
         categoriaRepositoryJPA.save(categoria);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        categoriaRepositoryJPA.deleteById(id);
    }



}
