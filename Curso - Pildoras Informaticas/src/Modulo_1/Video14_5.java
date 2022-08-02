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

public class Video14_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Declaramos nuestro objeto para luego usar
        // los métodos
        
        System.out.println("Cual es tu nombre ?");        
        String name = input.nextLine();
        
        System.out.println("Cual es tu edad ?");        
        int age = input.nextInt();        
        System.out.println("Hola " + name + ".El año anterior tuviste " + (age - 1) + " años.");
    }
}
