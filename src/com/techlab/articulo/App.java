package com.techlab.articulo;


import java.util.Scanner;
import com.techlab.articulo.menu.MenuArticulos;
import com.techlab.articulo.menu.MenuCategorias;
import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

public class App {
    public static void main(String[] args) {
        //1. Instanciar los recursos comunes
        Scanner sc = new Scanner(System.in);
        Repositorio<Categoria> repoCategorias = new Repositorio<>();
        Repositorio<Articulo> repoArticulos = new Repositorio<>();

        //2. Precarga de datos simulando la base de datos del kiosco Las Tinas
        precargarDatos(repoCategorias);

        //3. Crear instancias de los menús delegando responsabilidades
        MenuCategorias menuCat = new MenuCategorias(sc, repoCategorias);
        MenuArticulos menuArt = new MenuArticulos(sc, repoArticulos, repoCategorias);

        //4. Bucle principal
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN 'LAS TINAS' ===");
            System.out.println("1 - Gestión de Artículos");
            System.out.println("2 - Gestión de Categorías");
            System.out.println("0 - Salir");
            System.out.println("======================================");

            System.out.print("Elija una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    menuArt.ejecutar();
                    break;
                case 2:
                    menuCat.ejecutar();
                    break;
                case 0:
                    System.out.println("Cerrando el sistema. ¡Gracias por usar Las Tinas!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void precargarDatos(Repositorio<Categoria> repo){
        repo.agregar(new Categoria(com.techlab.articulo.utils.Secuencias.generarCodigoCategoria(), "Dulces", "Caramelos y chocolates"));
        repo.agregar(new Categoria(com.techlab.articulo.utils.Secuencias.generarCodigoCategoria(), "Tecnología", "Accesorios y electrónica"));
    }
}
