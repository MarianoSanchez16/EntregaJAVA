package com.techlab.articulo.utils;

public final class Validaciones {
    public static boolean validarNoNegativo(int valor){
        return valor>=0;
    }

    public static boolean validarNoNegativo(double valor){
        return valor>=0;
    }

    public static boolean validarTextoNoVacio(String texto){
        return texto != null && !texto.trim().isEmpty();
    }
}