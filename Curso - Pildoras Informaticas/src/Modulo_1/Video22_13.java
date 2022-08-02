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

import javax.swing.JOptionPane;

public class Video22_13 {
    public static void main(String[] args) {
    int result = 1;
    int number = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
    
    for(int i = number; i > 0; i--) {
        result *= i;
    }
    System.out.println("El factorial de " + number + " es " + result);
    }
    // Probando con el factorial de 20 ya desbordamos la capacidad que puede almacenar un entero (-2^31 - 2^31 + 1)            
}

