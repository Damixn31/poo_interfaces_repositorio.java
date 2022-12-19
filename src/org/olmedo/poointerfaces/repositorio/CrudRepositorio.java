package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
  // alistar para optener todos los clientes
  List<Cliente> listar();
  Cliente porId(Integer id); //para obtener un cliente por ID
  void crear(Cliente cliente);
  void editar(Cliente cliente);
  void eliminar(Integer id);
}
