package org.olmedo.genericsclass;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class Camion<T> implements Iterable<T> {
  //clase generica le paso por parametros la T
  private List<T> objetos;
  private int max;


  public Camion(int max){
    this.max = max;
    this.objetos = new ArrayList<>();
  }

  public void add(T objeto) {
    if(this.objetos.size() <= max) {
       this.objetos.add(objeto);
    } else {
      throw new RuntimeException("No hay mas espacio.");
    }

  }
  @Override 
  public Iterator<T> iterator(){
    return this.objetos.iterator();
  }
}
