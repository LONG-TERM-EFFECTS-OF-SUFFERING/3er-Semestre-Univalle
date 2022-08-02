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

public class Video19_10 {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100); // Generamos el numero aleatorio entre 1 - 100
        // Vamos a usar el random para sacar porcentajes del valor original, lo que para nosotros
        // va a ser aleatorio       
        int attempts = 3;       
        int proposedNumber = -1; // Lo inicializamos en un caso imposible
        
        Scanner input = new Scanner(System.in);
        System.out.println(number);
        
        // La condición par continuar es no haber adivinado el numero y tener intentos disponibles
        while(number != proposedNumber && attempts != 0) {
            System.out.println("Introduce un numero");
            number = input.nextInt();            
            attempts--;
            System.out.println("Tienes " + attempts + " intentos");

            if(proposedNumber > number) {
                System.out.println("El numero es mas pequeño");
            } else {
                System.out.println("El numero es mas grande");
            }       
        }

        if(number == proposedNumber) {
            System.out.println("Felicidades acertaste");
        } else {
            System.out.println("Lo lamento, gastaste tus intentos");
        }
        
        // Debido a que nuestra declaración (int) (Math.random() * 100) puede dar cero la entrada en
        // el while puede dar False sin si quiera preguntar por un numero, para solucionar esto
        // usaremos un do - while
        /*
        do { // Con esto aseguramos que la inicializacion la haga el usuario
            System.out.println("Introduce un numero");
            number = input.nextInt();            
            attempts--;
            System.out.println("Tienes " + attempts + " intentos");
            if(proposedNumber > number) {
                System.out.println("El numero es mas pequeño");
            } else {
                System.out.println("El numero es mas grande");
            }
        } while(number != proposedNumber && attempts != 0);
        */
        // Con la comprobacion que ya hacemos al salir del while
    }
}
