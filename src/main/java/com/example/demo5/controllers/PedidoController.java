package com.example.demo5.controllers;

import com.example.demo5.domain.Pedido;
import com.example.demo5.repositories.PedidoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepositoryJPA pedidoRepositoryJPA;

    @GetMapping
    public List<Pedido> findAll() {
        List<Pedido> pedidos = pedidoRepositoryJPA.findAll();
        return pedidos;
    }

    @GetMapping(value = "/{id}")
    public Pedido get(@PathVariable(name = "id") Long id) {
        Pedido pedido = pedidoRepositoryJPA.findById(id).orElse(null);
        return pedido;
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        pedido = pedidoRepositoryJPA.save(pedido);
        return pedido;
    }

    @PostMapping("/pedidos")
    public List<Pedido> criarPedidos(@RequestBody List<Pedido> pedidos) {
        return pedidoRepositoryJPA.saveAll(pedidos);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Pedido pedido) {
        pedido.setId(id);
        pedidoRepositoryJPA.save(pedido);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        pedidoRepositoryJPA.deleteById(id);
    }
}
