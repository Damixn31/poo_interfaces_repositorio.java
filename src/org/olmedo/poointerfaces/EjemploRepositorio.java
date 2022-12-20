package org.olmedo.poointerfaces;

import org.olmedo.poointerfaces.modelo.Cliente;
import org.olmedo.poointerfaces.repositorio.*;
import org.olmedo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
  public static void main(String[] args){

    TodosLosRepositorios<Cliente> repo = new ClienteListRepositorio();
    repo.crear(new Cliente("Jano", "Perez"));
    repo.crear(new Cliente("Bea", "Gonzalez"));
    repo.crear(new Cliente("Luci", "Martinez"));
    repo.crear(new Cliente("Andrez", "Guzman"));

    List<Cliente> clientes = repo.listar();
    clientes.forEach(System.out::println);

    System.out.println("===== Paginable =====");

    List<Cliente> paginable = repo.listar(1, 3);
    paginable.forEach(System.out::println);


    System.out.println("===== Ordenando =====");

    List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);  
    for(Cliente c: clientesOrdenAsc){
      System.out.println(c);
    }

    System.out.println("===== Editar =====");

    Cliente beaActualizar = new Cliente("Bea", "Olmedo");
    beaActualizar.setId(2); // importante poner el id que quiero modificar sino va a generar un nuevo id
    repo.editar(beaActualizar);
    Cliente bea = repo.porId(2);
    System.out.println(bea);
    System.out.println(" ============= ");
    repo.listar("nombre", Direccion.DESC).forEach(System.out::println);

    System.out.println("===== Eliminar =====");
    repo.eliminar(2);
    repo.listar().forEach(System.out::println);
    System.out.println(" ====== Total ======= ");
    System.out.println("Total registros : " + repo.total());
    

  }
}
