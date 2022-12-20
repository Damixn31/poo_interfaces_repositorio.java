package org.olmedo.poointerfaces.repositorio.lista;

import org.olmedo.poointerfaces.modelo.Producto;
import org.olmedo.poointerfaces.repositorio.AbstractaListRepositorio;
import org.olmedo.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
  @Override
  public void editar(Producto producto) {
    Producto p = porId(producto.getId()); 
    p.setDescription(producto.getDescription());
    p.setPrecio(producto.getPrecio());

  }

  @Override
  public List<Producto> listar(String campo, Direccion dir){
    List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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
  public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
          switch(campo){
            case "id" ->
              resultado = a.getId().compareTo(b.getId());
            case "description" ->
              resultado = a.getDescription().compareTo(b.getDescription());
            case "precio" -> 
              resultado = a.getPrecio().compareTo(b.getPrecio());
          }
          return resultado;
 
      }


}
