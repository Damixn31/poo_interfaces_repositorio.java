package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.*;
import org.olmedo.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
  // alistar para optener todos los Ts
  List<T> listar();
  T porId(Integer id) throws AccesoDatoException;
  void crear(T t) throws AccesoDatoException;
  void editar(T t) throws AccesoDatoException;
  void eliminar(Integer id)throws AccesoDatoException;
}
