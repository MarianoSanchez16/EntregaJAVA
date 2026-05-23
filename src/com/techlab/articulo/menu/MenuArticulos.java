package com.techlab.articulo.menu;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloAlimenticio;
import com.techlab.articulo.model.ArticuloElectronico;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;
import java.util.Scanner;

public class MenuArticulos extends Menu {
    private Repositorio<Articulo> repoArticulos;
    private Repositorio<Categoria> repoCategorias;

    public MenuArticulos(Scanner sc, Repositorio<Articulo> repoArticulos, Repositorio<Categoria> repoCategorias) {
        super(sc);
        this.repoArticulos = repoArticulos;
        this.repoCategorias = repoCategorias;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ARTÍCULOS (Las Tinas) ---");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elija una opción: ");

            switch (opcion) {
                case 1:
                    ingresarArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void ingresarArticulo(){
        System.out.println("\n-- Ingresar nuevo artículo --");
        if (repoCategorias.cantidad() == 0) {
            System.out.println("Error: Debe registrar al menos una Categoría antes de crear un artículo.");
            return;
        }

        int tipo = leerEntero("Seleccione tipo (1-Alimenticio, 2-Electrónico): ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido.");
            return;
        }

        String nombre = leerTextoNoVacio("Nombre del producto: ");
        double precio = leerDoubleNoNegativo("Precio base: $");

        System.out.println("Categorías disponibles:");
        for (Categoria c : repoCategorias.listar()){
            System.out.println(c.toString());
        }
        int idCat = leerEntero("Ingrese ID de la Categoría: ");
        Categoria categoriaAsignada = repoCategorias.buscarPorCodigo(idCat);

        if (categoriaAsignada == null){
            System.out.println("Categoría no encontrada. Operación cancelada.");
            return;
        }

        int codigo = Secuencias.generarCodigoArticulo();
        Articulo nuevoArticulo = null;

        if (tipo == 1){
            int dias = leerEntero("Dias para el vencimiento: ");
            nuevoArticulo = new ArticuloAlimenticio(codigo, nombre, precio, categoriaAsignada, dias);
        } else{
            int meses = leerEntero("Garantía en meses: ");
            nuevoArticulo = new ArticuloElectronico(codigo, nombre, precio, categoriaAsignada, meses);
        }

        if (repoArticulos.agregar(nuevoArticulo)) {
            System.out.println("Artículo registrado con éxito.");
        } else{
            System.out.println("Error al registrar el artículo");
        }
    }

    private void listarArticulos(){
        System.out.println("\n-- Catálogo de Artículos --");
        if (repoArticulos.cantidad() == 0) {
            System.out.println("No hay artículos en el sistema.");
            return;
        }

        for (Articulo a : repoArticulos.listar()){
            System.out.println(a.toString());
        }
    }
}
