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

package Modulo_1;

import java.util.Scanner;

public class Video48_22 {
    // Vamos a ver los tipo enumerados
    //enum Talla {Mini, Mediano, Grande, MuyGrande}
    // Otra forma de hacerlo
    enum Talla {
        // EL compilador crea los objetos con las siguiente declaracion:
        // public static final Talla MINI = new Talla(args);
        MINI("s"), 
        MEDIANO("m"), 
        GRANDE("l"), 
        MUY_GRANDE("xl"); // Se recomienda ponerlo todo en mayúsculas o
        // minúsculas para controlar mas casos (en la interacción con el usuario)
        
        private String alias;
        
        private Talla(String alias) { // Funciona como constructor y setter al mismo tiempo
            this.alias = alias;
        }
        
        private String getAlias() {
            return alias;
        }
        
        public String toString() { // Reescribimos lo que devuelve a monstrarlo en un SOUT            
            String text = "Talla " + alias; 
            return text;            
        }
    }

    public static void main(String[] args) {
        // No se admite la creación de objetos (es la idea de que esten enumerados)
        /*
        Talla s  = Talla.Mini;
        Talla m  = Talla.Mediano;
        Talla l  = Talla.Grande;
        Talla xl = Talla.MuyGrande;
        */
        Scanner input = new Scanner(System.in);        
        System.out.println("Escribe una talla: Mini, Mediano, Grande, MuyGrande");
        
        String UserTalla = input.next().toUpperCase(); // se usa .toUpperCase() para controlar mas casos       
        Talla tallaEscogida = Enum.valueOf(Talla.class, UserTalla);
        
        System.out.println("La abreviatura de la talla " + UserTalla + " es " + tallaEscogida.getAlias());
        
        Talla[] tallas = Talla.values(); // Guardamos los nombres de los objetos
        
        for(Talla talla:tallas) {
            System.out.println(talla);
        }
        
        System.out.println(Talla.MINI.ordinal()); // Nos muestra su posicion dentro del objeto enumerado
    }
}
