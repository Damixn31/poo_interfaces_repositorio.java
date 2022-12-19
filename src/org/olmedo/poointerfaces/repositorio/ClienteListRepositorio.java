package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.*;

import java.util.ArrayList;

import java.util.List;

public class ClienteListRepositorio implements TodosLosRepositorios {

  private List<Cliente> dataSource; // este es el contenedor de los datos donde se va almacenar y realizar las operaciones

  public ClienteListRepositorio(){
    this.dataSource = new ArrayList<>();
  }

  @Override
  public List<Cliente> listar(){
    return dataSource;
  }

  @Override
 public Cliente porId(Integer id){
    Cliente resultado = null;
    for(Cliente cli: dataSource){
      if(cli.getId() != null && cli.getId().equals(id)){
        resultado = cli;
        break;
      }
    }
    return resultado;
  }

  @Override
  public void crear(Cliente cliente){
    this.dataSource.add(cliente);
    
  }

  @Override
  public void editar(Cliente cliente){
    Cliente c = this.porId(cliente.getId());
    c.setNombre(cliente.getNombre());
    c.setApellido(cliente.getApellido());
  }

  @Override
  public void eliminar(Integer id){
    //Cliente c = this.porId(id);
    //this.dataSource.remove(c);
    this.dataSource.remove(this.porId(id));
  }

  @Override
  public List<Cliente> listar(String campo, Direccion dir){
    List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource); // para que no modifique la lista original
    listaOrdenada.sort((a, b) -> {
        int resultado = 0;
        if(dir == Direccion.ASC){
          resultado = ordenar(campo, a, b); 
        } else if(dir == Direccion.DESC){
          resultado = ordenar(campo, b, a);        
        }
        return resultado;
    });
    return listaOrdenada;
  }

  @Override
  public List<Cliente> listar(int desde, int hasta){
    return dataSource.subList(desde, hasta);
  }
  // Metodo propio de la clase esto esta bien cuando solo usamos en una misma clase 
 public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
          switch(campo){
            case "id" ->
              resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
              resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> 
              resultado = a.getApellido().compareTo(b.getApellido());
          }
          return resultado;
 
      }
 @Override
 public int total(){
   return this.dataSource.size();
 }
}
