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

import javax.swing.JOptionPane;

public class Video147_ {
    public static void main(String[] args) {

        String email = JOptionPane.showInputDialog("Introduce tu email ");
        
        try {
           examineEmail(email); 
        } catch(wrongLengthEmail e) { // Podemos capturar tambien un Exception
            System.out.println("El email introducido es invalido !");
            e.printStackTrace();
        }
            
    }
    
    static void examineEmail(String email) throws wrongLengthEmail {
        // Vamos a comprobar si un mail esta escrito correctamente
        // lo tomaremos como correcto si tiene al menos un "." y solo una "@" 
        boolean arroba = false; 
        boolean dot = false; 
        int emailLength = email.length();
        
        if(emailLength <= 3) {
            throw new wrongLengthEmail("El mail es demasiado corto (menos de tres caracteres)");
        } else {
            for(int i = 0; i < emailLength; i++) {
                char character = email.charAt(i);

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
        }    
        System.out.println(arroba && dot);
    }
}

class wrongLengthEmail extends Exception {   
    public wrongLengthEmail() {
    }    
    
    public wrongLengthEmail(String message) {
        super(message);
    }  
}
