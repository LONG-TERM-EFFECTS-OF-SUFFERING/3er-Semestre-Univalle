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

public class Video16_7 {
    public static void main(String[] args) {
        // Flujo del programa con condicionales
        Scanner input = new Scanner(System.in);       
        System.out.println("Introduce tu edad:");
        int age = input.nextInt();
        
        if(age < 18) {
            System.out.println("Eres un adolescente");
        } else if(age < 40) {
            System.out.println("Eres joven");
        } else if(age < 65) {
            System.out.println("Eres maduro");
        } else {
            System.out.println("Cuídate");
        }          
    }
}
