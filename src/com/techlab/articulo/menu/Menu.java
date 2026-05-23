package com.techlab.articulo.menu;

import java.util.Scanner;

public abstract class Menu {
    protected Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

    public abstract void mostrarMenu();
    public abstract void ejecutar();

    protected int leerEntero(String mensaje){
        while (true){
            try{
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }
    }

    protected double leerDoubleNoNegativo(String mensaje){
        while (true){
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(sc.nextLine().trim());
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("Error: El valor no puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico válido.");
            }
        }
    }

    protected String leerTextoNoVacio(String mensaje){
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: El texto no puede estar vacío.");
        }
    }
}
