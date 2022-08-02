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

public class Video21_12 {
    public static void main(String[] args) {
        // Vamos a comprobar si un mail esta escrito correctamente
        // lo tomaremos como correcto si tiene al menos un "." y solo una "@" 
        boolean arroba = false; // Vamos a suponer que el correo ingresado no la tiene, hasta que demostremos que si
        boolean dot = false; // Vamos a hacer el mismo análisis de arriba  
        String mail = JOptionPane.showInputDialog("Introduce tu email ");

        for(int i = 0; i < mail.length(); i++) {
            char character = mail.charAt(i);

            if(character == '@') {
                if(!arroba) { // Si es la primera y única "@"
                    arroba = true;
                } else {
                    arroba = false;
                    break; // Si encontramos otra "@" detenemos el for con arroba en false
                } 
            } else if(character == '.') { // Como estamos comparando chars podemos usar "=="
                if(!dot) {
                    dot = true;        
                }               
            }
        }   
    System.out.println(arroba && dot);            
    }
}
