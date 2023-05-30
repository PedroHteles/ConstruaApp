package com.example.demo5.controllers;

import com.example.demo5.domain.Cliente;
import com.example.demo5.repositories.ClienteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositoryJPA clienteRepository;

    @GetMapping
    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @GetMapping(value = "/{id}")
    public Cliente get(@PathVariable(name = "id") Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        cliente = clienteRepository.save(cliente);
        return cliente;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteRepository.save(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        clienteRepository.deleteById(id);
    }
}
