/*
                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ Brandon Calderón Prieto  
       .---.         
      /     \   calderon.brandon@correounivalle.edu.co     
      \.@-@./               
      /`\_/`\               202125974
     //  _  \\        
    | \     )|_        Ingeniería de sistemas
   /`\_`>  <_/ \
   \__/'---'\__/
 */

package Modulo_4;

import java.util.*;

public class Video185_ {
    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<>();
        LinkedList<String> capitals = new LinkedList<>();
        
        countries.add("España");
        countries.add("Colombia");
        countries.add("Mexico");
        countries.add("Peru");
        // Los elementos los agrega al final
        capitals.add("Madrid");
        capitals.add("Bogota");
        capitals.add("DF");
        capitals.add("Lima");
        
        ListIterator<String> it1 = countries.listIterator();
        ListIterator<String> it2 = capitals.listIterator();
        
        while(it1.hasNext()) {
            // Avanzamos una posicion y agrego la capital en la siguiente, dejando el iterador una posicion
            // mas adelante
            it1.next();
            it1.add(it2.next()); // Como tienen el mismo numero de elementos no tenemos que preocuparnos
            // por salirnos de la lista
        }
        System.out.println(countries);
        // En este momento el it1 y ite2 estan en las posiciones finales
        it2 = capitals.listIterator(); // Lo volvemos inicializar
        while(it2.hasNext()) {
            // Sabiendo que hay un numero par de capitales
            it2.next();
            it2.next();
            it2.remove();
        }
        System.out.println(capitals);
        //it.next(); // Estabamos en la posicion 0, asi que un next() nos lleva a la 1
        //it.add("Juan"); // Agregamos el elemento "Juan" en la posicion 1, desplazando los demas
        // arriba
        
        
    };
}
