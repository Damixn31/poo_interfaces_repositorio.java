package org.olmedo.poointerfaces.repositorio;

// Esto es herencia multiple de interface
public interface TodosLosRepositorios<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
