package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Calculable;
import com.techlab.articulo.interfaces.Identificable;
import com.techlab.articulo.utils.Validaciones;

public abstract class Articulo implements Calculable, Identificable {
    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Articulo() {}

    public Articulo(int codigo, String nombre, double precio, Categoria categoria){
        this.codigo = codigo;
        setNombre(nombre);
        setPrecio(precio);
        this.categoria = categoria;
    }

    @Override
    public int getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        if(Validaciones.validarTextoNoVacio(nombre)){
            this.nombre = nombre.trim();
        }
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        if(Validaciones.validarNoNegativo(precio)){
            this.precio = precio;
        }
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "Cod: " + codigo + " | " + nombre + " | Precio base: $" + precio + " | " + categoria.getNombre();
    }
}
