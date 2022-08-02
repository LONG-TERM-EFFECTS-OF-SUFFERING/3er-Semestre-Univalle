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

package Modulo_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Video142_ {
    public static void main(String[] args) {
        System.out.println("¿Que quieres hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");
        
        Scanner input = new Scanner(System.in);
        
        int decision = input.nextInt();
        
        if(decision == 1) {
            // Ya que el metodo lanza la excepcion, lo ideal es capturarla fuera del metodo
            try {
                askData();
            } catch(Exception e) { 
            System.out.println("Hemos terminado");
        }
        } else {
            System.out.println("Adios");
            System.exit(0);
        }      
        input.close();      
    }
    
    static void askData() throws InputMismatchException { // Se usa throws con caracter informativo
        // Aun que vayamos a capturar la excepcion, no es buena practica porque es una excepcion
        // no comprobada
        //try {
            
        Scanner input = new Scanner(System.in);
        
        System.out.println("Introduce tu nombre, por favor");       
        String name = input.nextLine();       
        System.out.println("Introduce edad, por favor");
        int age = input.nextInt();
        
        System.out.println("Hola " + name + ". El año que vienen tendrás " + (age + 1) + " años");
        
        input.close();        
            
            
        //} catch(InputMismatchException e) { // Tabien podemos capturarla con Exception (ya que todas las 
        // excepciones heredan de el)
            System.out.println("Hemos terminado");
       //}    
    }
}
