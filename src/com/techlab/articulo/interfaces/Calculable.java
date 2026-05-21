package com.techlab.articulo.interfaces;

public interface Calculable {
    double calcularPrecioFinal();

    default String descripcionCalculo(){
        return "Este objeto puede calcular un valor final";
    }
}
