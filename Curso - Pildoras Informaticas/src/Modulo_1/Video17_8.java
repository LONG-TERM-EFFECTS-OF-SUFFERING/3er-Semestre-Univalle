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

public class Video17_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        System.out.println("Elige una opción: \n1. Cuadrado \n2. Rectángulo \n3. Triangulo \n4. Circulo");       
        int option = input.nextInt();
        
        switch(option) {
            case 1: // Cuadrado
                int side = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado: "));
                System.out.println("El area del cuadrado es " + Math.pow(side, 2));
                break;
            case 2: // Rectángulo
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                int height = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                System.out.println("El area del rectángulo es " + (base * height));
                break;
            case 3: // Triangulo
                base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                height = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                System.out.println("El area del triangulo es " + (base * height / 2));
                break;
            case 4: // Circulo
                int radius = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
                System.out.println("El area del circulo es");
                System.out.printf("%1.2f", Math.pow(radius, 2) * Math.PI);
                break;
            default:
                System.out.println("La opción introducida no es correcta");
        }
    }
}
