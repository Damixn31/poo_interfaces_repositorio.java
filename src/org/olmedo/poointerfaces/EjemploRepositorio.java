package org.olmedo.poointerfaces;

import org.olmedo.poointerfaces.modelo.Cliente;
import org.olmedo.poointerfaces.repositorio.*;
import org.olmedo.poointerfaces.repositorio.excepciones.*;
import org.olmedo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
  public static void main(String[] args){

    try{
    TodosLosRepositorios<Cliente> repo = new ClienteListRepositorio();
    repo.crear(new Cliente("Jano", "Perez"));
    repo.crear(new Cliente("Bea", "Gonzalez"));
    repo.crear(new Cliente("Luci", "Martinez"));
    Cliente andres = new Cliente("Andrez", "Guzman");
    repo.crear(andres);
    repo.crear(andres);

    //repo.crear(null);

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
    // siempre en el manejo de excepciones van las clases hijas despues las padres
    } catch (RegistroDuplicadoAccesoDatoException e) {
      System.out.println("Registro Duplicado: " + e.getMessage());
      e.printStackTrace();
    } catch (LecturaAccesoDatoException e) {
      System.out.println("Lectura: " + e.getMessage());
      e.printStackTrace();

    } catch (EscrituraAccesoDatoException e) {
      System.out.println("Escritura: " + e.getMessage());
      e.printStackTrace();
 
    } 
    catch (AccesoDatoException e) {
      System.out.println("Padre: " + e.getMessage());
      e.printStackTrace();
    }

  }
}
