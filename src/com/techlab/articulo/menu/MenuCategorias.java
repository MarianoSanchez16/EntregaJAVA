package com.techlab.articulo.menu;

import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;
import java.util.Scanner;

public class MenuCategorias extends Menu {
    private Repositorio<Categoria> repoCategorias;

    public MenuCategorias(Scanner sc, Repositorio<Categoria> repoCategorias) {
        super(sc);
        this.repoCategorias = repoCategorias;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ CATEGORÍAS (Las Tinas) ---");
        System.out.println("1 - Ingresar categoría");
        System.out.println("2 - Listar categorías");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elija una opción: ");

            switch (opcion){
                case 1:
                    ingresarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void ingresarCategoria(){
        System.out.println("\n-- Ingresar nueva categoría --");
        String nombre = leerTextoNoVacio("Nombre: ");
        String descripcion = leerTextoNoVacio("Descripción: ");

        Categoria nueva = new Categoria(Secuencias.generarCodigoCategoria(), nombre, descripcion);
        if (repoCategorias.agregar(nueva)){
            System.out.println("Categoría registrada con éxito.");
        } else {
            System.out.println("Error al registrar la categoría.");
        }
    }

    private void listarCategorias(){
        System.out.println("\n-- Categorías registradas --");
        if(repoCategorias.cantidad() == 0){
            System.out.println("No hay categorías en el sistema.");
            return;
        }
        for (Categoria c : repoCategorias.listar()){
            System.out.println(c.toString());
        }
    }
}
