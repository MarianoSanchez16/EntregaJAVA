package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;
import com.techlab.articulo.utils.Validaciones;

public class Categoria implements Identificable {
    private int codigo;
    private String nombre;
    private String descripcion;

    public Categoria() {}

    public Categoria(int codigo, String nombre, String descripcion){
        this.codigo = codigo;
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    @Override
    public int getCodigo() {
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

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        if(Validaciones.validarTextoNoVacio(descripcion)){
            this.descripcion = descripcion.trim();
        }
    }

    @Override
    public String toString() {
        return "Cat [" + codigo + "] " + nombre + " (" + descripcion + ")";
    }
}