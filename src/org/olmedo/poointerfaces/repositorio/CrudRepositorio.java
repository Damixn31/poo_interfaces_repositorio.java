package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.*;

import java.util.List;

public interface CrudRepositorio<T> {
  // alistar para optener todos los Ts
  List<T> listar();
  T porId(Integer id); 
  void crear(T t);
  void editar(T t);
  void eliminar(Integer id);
}
