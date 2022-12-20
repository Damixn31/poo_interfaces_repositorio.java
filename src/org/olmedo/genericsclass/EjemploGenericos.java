package org.olmedo.genericsclass;

public class EjemploGenericos {
  //metodo generico a estos metodos tenemos que hacer el cast 
  public static <T> void imprimirCamion(Camion<T> camion){
    for(T a: camion){
      if(a instanceof Animal){
         System.out.println(((Animal)a).getNombre() + " tipo: " + ((Animal)a).getTipo());

      }
      else if(a instanceof Automovil){

         System.out.println(((Automovil)a).getMarca());
      } else if(a instanceof Maquinaria){
          System.out.println(((Maquinaria)a).getTipo());

      }
    }
  }
  public static void main(String[] args){

    Camion<Animal> transporteCaballos = new Camion<>(5);
    transporteCaballos.add(new Animal("Peregrino", "Caballo"));
    transporteCaballos.add(new Animal("Grillo", "Caballo"));
    transporteCaballos.add(new Animal("Tunquen", "Caballo"));
    transporteCaballos.add(new Animal("topocalma", "Caballo"));
    transporteCaballos.add(new Animal("Roldan", "Caballo"));

    imprimirCamion(transporteCaballos);

    Camion<Maquinaria> transMaquinas = new Camion<>(3);
    transMaquinas.add(new Maquinaria("Buldozer"));
    transMaquinas.add(new Maquinaria("Grua Arquilla"));
    transMaquinas.add(new Maquinaria("Perforadora"));

    imprimirCamion(transMaquinas);

    Camion<Automovil> transAuto = new Camion<>(3);
    transAuto.add(new Automovil("Toyota"));
    transAuto.add(new Automovil("Subaru"));
    transAuto.add(new Automovil("Mazda"));

    imprimirCamion(transAuto);
     }
}
