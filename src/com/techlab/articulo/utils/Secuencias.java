package com.techlab.articulo.utils;

public final class Secuencias {

    private static int proximoCodigoArticulo = 1;
    private static int proximoCodigoCategoria = 1;

    public static int generarCodigoArticulo(){
        return proximoCodigoArticulo++;
    }

    public static int generarCodigoCategoria(){
        return proximoCodigoCategoria++;
    }
}
