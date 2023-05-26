package com.example.demo5.enumerate;

public enum UnidadeMedida {
    KG,M;

    public static UnidadeMedida valueOfIgnoreCase(String value) {
        for (UnidadeMedida unidade : values()) {
            if (unidade.name().equalsIgnoreCase(value)) {
                return unidade;
            }
        }
        throw new IllegalArgumentException("Unidade de medida inválida: " + value);
    }
}
