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

public class Video20_11 {
    public static void main(String[] args) {
        String gender = "";
        
        do {
            gender = JOptionPane.showInputDialog("Introduce tu genero: hombre(H) o mujer(M)");
        } while(!(gender.equalsIgnoreCase("H") || gender.equalsIgnoreCase("M"))); // Se repite hasta que ingrese una opción valida       
        // Si salimos del bucle significa que el usuario introdujo una opción valida
        
        int height = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));      
        int idealWeight = 0; // Inicializamos
        
        if(gender.equalsIgnoreCase("H")) {
            idealWeight = height - 110;
        } else {
            idealWeight = height - 120;
        }

        System.out.println("Tu peso ideal es " + idealWeight + " Kg");
    }
}
