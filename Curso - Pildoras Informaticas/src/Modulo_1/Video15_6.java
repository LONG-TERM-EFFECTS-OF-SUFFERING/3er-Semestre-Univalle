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
import javax.swing.JOptionPane;

public class Video15_6 {
    public static void main(String[] args) {
        // Siempre se usan métodos estáticos, parecido a usar la librería Math
        String name = JOptionPane.showInputDialog("Ingrese su nombre, por favor");
        
        String ageString = JOptionPane.showInputDialog("Ingrese su edad, por favor");
        
        int age = Integer.parseInt(ageString); // Lo convertimos a entero, la estructura es 
        // parecida para otros tipos de datos, ejemplo Double = Double.parseDouble(String)       
        System.out.println("Hola " + name + ", tendrás " + (age + 1) + " el proximo año.");
        
        Scanner input = new Scanner(System.in);       
        System.out.println("Ahora ingrese un numero, para sacarle su raíz cuadrada:");        
        double number = input.nextDouble();       
        System.out.printf("%1.2f", Math.sqrt(number));
    }
}
