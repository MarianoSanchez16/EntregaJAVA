package com.techlab.articulo.model;

import com.techlab.articulo.utils.Validaciones;

public class ArticuloAlimenticio extends Articulo {
    private int diasParaVencimiento;

    public ArticuloAlimenticio(){ super(); }

    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento){
        super(codigo, nombre, precio, categoria);
        setDiasParaVencimiento(diasParaVencimiento);
    }

    public int getDiasParaVencimiento(){
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int dias){
        if(Validaciones.validarNoNegativo(dias)){
            this.diasParaVencimiento = dias;
        }
    }

    @Override
    public double calcularPrecioFinal(){
        // Regla de Las Tinas: Si vence en menos de 3 días, tiene descuento del 30%
        if (diasParaVencimiento <=3){
            return getPrecio() * 0.7;
        }
        return getPrecio();
    }

    @Override
    public String toString(){
        return super.toString() + " | Vence en: " + diasParaVencimiento + " dias | Precio Final: $" + calcularPrecioFinal();
    }
}