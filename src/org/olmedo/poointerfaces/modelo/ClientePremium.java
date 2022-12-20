package org.olmedo.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium> {

   public ClientePremium(String nombre, String apellido){
     super(nombre, apellido);
   }

   @Override
   public int compareTo(ClientePremium o){ // aca podemos comparar por nombre, apellido, id por lo que queremos
     return 0;
   }
}
