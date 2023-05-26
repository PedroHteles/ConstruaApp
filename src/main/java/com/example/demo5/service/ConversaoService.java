package com.example.demo5.service;

import org.springframework.stereotype.Service;

@Service
public class ConversaoService {

    public double converterUnidade(String unidadeOrigem, String unidadeDestino, double valor) {
        if (unidadeOrigem.equals("grama") && unidadeDestino.equals("kg")) {
            return valor / 1000;
        } else if (unidadeOrigem.equals("m") && unidadeDestino.equals("cm")) {
            return valor * 100;
        }
        // ... adicione outros casos de conversão conforme necessário
        throw new IllegalArgumentException("Conversão não suportada: " + unidadeOrigem + " para " + unidadeDestino);
    }
}