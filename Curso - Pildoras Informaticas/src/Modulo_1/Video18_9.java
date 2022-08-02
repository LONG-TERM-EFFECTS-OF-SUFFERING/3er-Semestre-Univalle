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

public class Video18_9 {
    public static void main(String[] args) {
        String originalPassword = "Juan";
        String userPassword = "";
        
        while(!userPassword.equals(originalPassword)) { // Mientras no acerté la contraseña
            userPassword = JOptionPane.showInputDialog("Introduce la contraseña");

            // Mostramos un mensaje
            if(!userPassword.equals(originalPassword)) {
                System.out.println("Contraseña incorrecta !");
            }
        }       
        // Si llego hasta aquí significa que salio del while
        System.out.println("Contraseña correcta !");
    }
}
