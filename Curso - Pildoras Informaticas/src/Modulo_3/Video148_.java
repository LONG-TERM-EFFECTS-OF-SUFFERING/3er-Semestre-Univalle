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

public class Video148_ {
    public static void main(String[] args) {
        // Estamos capturando excepciones no controladas (lo cual no es buena practica)
        try {
            divition();
        } catch(ArithmeticException e) {
            System.out.println("Estas dividiendo por 0");
        } catch(NumberFormatException e) {
            System.out.println("No has introducido un numero entero");
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error del tipo " + e.getClass().getName());
        }
    }
    
    static void divition() {
        int dividend = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo:"));
        int divider = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor:"));
        
        System.out.println("El resutado es: " + dividend / divider);
        
    }
}
