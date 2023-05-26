package com.example.demo5.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pedido {

    public enum Status {
        ABERTO, PROCESSADO, ERRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "total_pedido")
    private BigDecimal total = BigDecimal.ZERO;

    @ManyToOne(optional = false)
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
