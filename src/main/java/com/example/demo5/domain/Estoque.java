package com.example.demo5.domain;

import javax.persistence.*;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduto;
    private Long idLoja;
    private Long quantidade;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdLoja() {
        return this.idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}