package com.example.demo5.dtos;

import com.example.demo5.enumerate.UnidadeMedida;
import com.example.demo5.utils.unitConverter;

public class ProdutoRequisicao {

    private String nome;
    private Double quantidade;
    private String preferenciaMarca;
    private String unidadeMedida;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidade() {
        if(unidadeMedida.equals(UnidadeMedida.M.name())){
            return unitConverter.metersToCm(quantidade);

        }else{
            return unitConverter.kgToG(quantidade);
        }
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreferenciaMarca() {
        return preferenciaMarca;
    }


    public UnidadeMedida getUnidadeMedia() {
        if (unidadeMedida != null) {
            return UnidadeMedida.valueOf(unidadeMedida.toUpperCase());
        }
        return null;
    }

    public void setUnidadeMedia(String unidadeMedida) {
        if (unidadeMedida != null) {
            this.unidadeMedida = unidadeMedida;
        }
    }
}
