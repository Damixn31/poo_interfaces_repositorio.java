package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
  List<Cliente> listar(int desde, int hasta);
}
