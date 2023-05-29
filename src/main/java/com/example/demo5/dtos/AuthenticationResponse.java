package com.example.demo5.dtos;

import com.example.demo5.domain.Cliente;

public class AuthenticationResponse {
    private String token;
    private Cliente cliente;

    public AuthenticationResponse(String token, Cliente cliente) {
        this.token = token;
        this.cliente = cliente;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
