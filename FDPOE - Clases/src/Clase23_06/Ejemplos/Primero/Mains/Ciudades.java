package Clase23_06.Ejemplos.Primero.Mains;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Ciudades {
    public static void main(String[] args) {
        /* Array convencional
        Persona[] listado = new Persona[5];
        
        listado[0] = new Persona("Pepito", (byte) 5);
        listado[1] = new Persona("Juanito", (byte) 15);
        listado[2] = new Persona("Maria", (byte) 25);
        listado[3] = new Persona("Pedro", (byte) 50);
        listado[4] = new Persona("Tomas", (byte) 15);
        
        for (int i = 0; i < listado.length; i++) {
            System.out.println(listado[i]);
        }
        */
        //ArrayList<String> ciudades = new ArrayList<String>();
        //LinkedList<String> ciudades = new LinkedList<String>();
        Vector <String> ciudades = new Vector<>(); // El vector acepta objetos de tipo String
        System.out.println("Cantidad : " + ciudades.size());
        // Cuando agregamos con add la posicion del elemento agregado le corresponde a el tamaño del vector
        ciudades.add("Bogotá");
        ciudades.add("Cali");
        ciudades.add("Medellín");
        ciudades.set(2, "Tuluá");
        
        /* Hay metodos especificos para agregar en el principio y al final del vector
        ciudades.addFirst("Barranquilla");
        ciudades.addLast("Manizlez");
        */
        System.out.println("Cantidad : " + ciudades.size());
        System.out.println("Ciudad : " + ciudades.get(2));
        System.out.println("¿Está Bogotá? " + ciudades.contains("Cucutá"));
        /*
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println(ciudades.get(i)); // Con el metodo get(posicion) accedemos a los elementos
        // del vector
        }
        */
        
        /* Recorremos el vector con un ForEach
        for(String ciudad : ciudades){
            System.out.println(ciudad);
        }
        */
        //ciudades.remove(0);
        //ciudades.clear(); // Con este metodo eliminamos todos los elementos del vector
        if(!ciudades.isEmpty()) { // Iteramos sobre el vector (si este no esta vacio)
            ciudades.forEach((ciudad) -> {
            System.out.println(ciudad);
        });
        } else {
            System.out.println("No hay ciudades");
        }           
    }
}
