package org.olmedo.poointerfaces.repositorio;

import org.olmedo.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;

import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements TodosLosRepositorios<T> {

  protected List<T> dataSource; // este es el contenedor de los datos donde se va almacenar y realizar las operaciones

  public AbstractaListRepositorio(){
    this.dataSource = new ArrayList<>();
  }

  @Override
  public List<T> listar(){
    return dataSource;
  }

@Override
 public T porId(Integer id){
    T resultado = null;
    for(T cli: dataSource){
      if(cli.getId() != null && cli.getId().equals(id)){
        resultado = cli;
        break;
      }
    }
    return resultado;
  }

  @Override
  public void crear(T t){
    this.dataSource.add(t);
    
  }


  @Override
  public void eliminar(Integer id){
    //Cliente c = this.porId(id);
    //this.dataSource.remove(c);
    this.dataSource.remove(this.porId(id));
  }

  @Override
  public List<T> listar(int desde, int hasta){
    return dataSource.subList(desde, hasta);
  }
 @Override
 public int total(){
   return this.dataSource.size();
 }
}
