package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
  List<T> listar(String campo, Direccion dir); // aca le pasamos los campos y direccion que queremos ordenar
                    
  // esta es una de las maneras de implementar el metodo
  /*default int ordenar(String campo, Cliente a, Cliente b) {
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
 
      }*/
}
