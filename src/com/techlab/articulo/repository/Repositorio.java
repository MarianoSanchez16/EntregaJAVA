package com.techlab.articulo.repository;

import java.util.ArrayList;
import java.util.List;

import com.techlab.articulo.interfaces.Identificable;

public class Repositorio<T extends Identificable> {
    private final ArrayList<T> lista;

    public Repositorio(){
        this.lista = new ArrayList<>();
    }

    public boolean agregar(T objeto){
        if (objeto == null){
            return false;
        }
        
        if (buscarPorCodigo(objeto.getCodigo()) != null) {
            return false;
        }
        return lista.add(objeto);
    }

    public List<T> listar(){
        return new ArrayList<>(lista);
    }
    
    public T buscarPorCodigo(int codigo){
        for (T objeto : lista){
            if (objeto.getCodigo() == codigo){
                return objeto;
            }
        }
        return null;
    }

    public boolean eliminar(T objeto){
        return lista.remove(objeto);
    }

    public int cantidad(){
        return lista.size();
    }
}
