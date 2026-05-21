package com.techlab.articulo.model;

import com.techlab.articulo.utils.Validaciones;

public class ArticuloElectronico extends Articulo {
    private int garantiaMeses;

    public ArticuloElectronico() { super(); }

    public ArticuloElectronico(int codigo, String nombre, double precio, Categoria categoria, int garantiaMeses){
        super(codigo, nombre, precio, categoria);
        setGarantiaMeses(garantiaMeses);
    }

    public int getGarantiaMeses(){
        return garantiaMeses;
    }

    public void setGarantiaMeses(int meses){
        if (Validaciones.validarNoNegativo(meses)) {
            this.garantiaMeses = meses;
        }
    }

    @Override
    public double calcularPrecioFinal(){
        return getPrecio();
    }

    @Override
    public String toString(){
        return super.toString() + " | Garantia: " + garantiaMeses + " meses | Precio Final: $" + calcularPrecioFinal();
    }
}