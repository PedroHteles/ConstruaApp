package com.example.demo5.utils;

import com.example.demo5.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class OtimizadorCompra {

    public List<Produto> otimizarCompra(List<Produto> produtos, Double quantidadeDesejada) {
        produtos.sort(Comparator.comparing(Produto::getPreco));
        List<Produto> resultado = new ArrayList<>();
        Long quantidadeAtual = 0l;
        for (Produto produto : produtos) {
            while (quantidadeAtual + produto.getUnidadeVenda() <= quantidadeDesejada) {
                resultado.add(produto);
                quantidadeAtual += produto.getUnidadeVenda();
            }
        }
        return resultado;
    }
}
