package com.example.demo5.controllers;

import com.example.demo5.domain.Produto;
import com.example.demo5.dtos.ProdutoRequisicao;
import com.example.demo5.repositories.ProdutoRepositoryJPA;
import com.example.demo5.service.ConversaoService;
import com.example.demo5.utils.OtimizadorCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepositoryJPA produtoRepositoryJPA;

    @Autowired
    private ConversaoService conversaoService;

    @Autowired
    private OtimizadorCompra otimizadorCompra;

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepositoryJPA.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto get(@PathVariable(name = "id") Long id) {
        return produtoRepositoryJPA.findById(id).orElse(null);
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        produto = produtoRepositoryJPA.save(produto);
        return produto;
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Produto> findAllByCategory(@PathVariable Long categoriaId) {
        return produtoRepositoryJPA.findByCategoria_Id(categoriaId);
    }

    @PostMapping("/orcamento")
    public List<Produto> getOrcamento(@RequestBody List<ProdutoRequisicao> produtosRequisicao) {
        List<Produto> produtos = new ArrayList<>();
        for (ProdutoRequisicao produtoRequisicao : produtosRequisicao) {
            List<Produto> byNome = produtoRepositoryJPA.findByNome(produtoRequisicao.getNome());
            produtos.addAll(otimizadorCompra.otimizarCompra(byNome,produtoRequisicao.getQuantidade()));
        }
        return produtos;
    }

    @PostMapping("/batch")
    public List<Produto> createMultiple(@RequestBody List<Produto> produtos) {
        return produtoRepositoryJPA.saveAll(produtos);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Produto produto) {
        produto.setId(id);
        produto = produtoRepositoryJPA.save(produto);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        produtoRepositoryJPA.deleteById(id);
    }


}
