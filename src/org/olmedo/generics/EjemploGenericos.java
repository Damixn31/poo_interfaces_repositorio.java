package org.olmedo.generics;

import org.olmedo.poointerfaces.modelo.Cliente;
import org.olmedo.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

      List<Cliente> clientes = new ArrayList<>();
      clientes.add(new Cliente("Nicolas", "Olmedo"));

      //Cliente nicolas = (Cliente) clientes.get(0); // para obtener el cliente esta es una manera
      Cliente nicolas = clientes.iterator().next(); // esta es otra manera de obtenerun cliente
      
      Cliente[] clientesArreglo = {new Cliente("Luci", "Maritinez"), new Cliente("Sandra", "Escobar")};
      Integer[] enterosArreglo = {1,2,3};

      List<Cliente> clienteLista = fromArrayToList(clientesArreglo); // convierte un arreglo en una lista de clientes
      List<Integer> enterosLista = fromArrayToList(enterosArreglo);

      clienteLista.forEach(System.out::println);
      enterosLista.forEach(System.out::println);

      List<String> nombres = fromArrayToList(new String[]{"Damian", "Bruno", "Luci", "Sandra", "Marco"}, enterosArreglo);
      nombres.forEach(System.out::println);

      List<ClientePremium> clientesPremiumList = fromArrayToList(new ClientePremium[] {new ClientePremium("Paco", "Lopez")});

      imprimirClientes(clientes);
      imprimirClientes(clienteLista);
      imprimirClientes(clientesPremiumList);

      System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
      System.out.println("Maximo de 3, 9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
      System.out.println("Maximo de zanahoria, arandanos, manzana es: " + maximo("zanahoria", "arandanos", "manzana"));

        
    }

    // metodos genericos que se aplique a cualquier tipo de dato
    public static <T> List<T> fromArrayToList(T[] c) {
      return Arrays.asList(c);
    }
    // metodos genericos que se aplique a cualquier tipo de dato
    public static <T extends Number> List<T> fromArrayToList(T[] c) {
      return Arrays.asList(c);
    }

     public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
      return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
      for(G elemento: x){
        System.out.println(elemento);
      }
      return Arrays.asList(c);
    }

    //los comodines solo se puden usar con listas y no de sus hijos para poder pasar sus hijas ponemos el singno de pregunta y el extends
    public static void imprimirClientes(List<? extends Cliente> clientes){
      clientes.forEach(System.out::println);
    }

    // Calcular el objeto mayor puede ser un numero o string
    public static  <T extends Comparable<T>> T maximo(T a, T b, T c){
      T max = a;
      if(b.compareTo(max) > 0) {
        max = b;
      } 
      if(c.compareTo(max) > 0) {
        max = c;
      }
      return max;
    }

}
