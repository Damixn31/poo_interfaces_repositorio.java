package org.olmedo.poointerfaces;

import org.olmedo.poointerfaces.modelo.Cliente;
import org.olmedo.poointerfaces.modelo.Producto;
import org.olmedo.poointerfaces.repositorio.Direccion;
import org.olmedo.poointerfaces.repositorio.TodosLosRepositorios;
import org.olmedo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.olmedo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.olmedo.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.olmedo.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            TodosLosRepositorios<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.76));
            repo.crear(new Producto("Silla", 18));
            repo.crear(new Producto("Lampara", 44));
            repo.crear(new Producto("Nootebook", 22));

            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);

            System.out.println("===== Paginable =====");

            List<Producto> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);


            System.out.println("===== Ordenando =====");

            List<Producto> productosOrdenAsc = repo.listar("Description", Direccion.ASC);
            for (Producto c : productosOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("===== Editar =====");

            Producto lamparaActualizar = new Producto("Lampara escritorio", 23);
            lamparaActualizar.setId(3); // importante poner el id que quiero modificar sino va a generar un nuevo id
            repo.editar(lamparaActualizar);
            Producto lampara = repo.porId(3);
            System.out.println(lampara);
            System.out.println(" ============= ");
            repo.listar("precio", Direccion.DESC).forEach(System.out::println);

            System.out.println("===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);
            System.out.println(" ====== Total ======= ");
            System.out.println("Total registros : " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
