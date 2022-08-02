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

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Video149_ {
    static int option; // Tiene que ser static porque el main es un metodo static
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        System.out.println("Elige una opción: \n1. Cuadrado \n2. Rectángulo \n3. Triangulo \n4. Circulo");   

        // Para que la ejecucion del programa siga si ocurre un error, capturemoslo
        try {
            option = input.nextInt();
        } catch(Exception e) {
            System.out.println("Ha ocurrido un error");
        } finally {
            input.close(); // Cerramos la conexion si la conversion sale bien o mal
        }
               
        switch(option) {
            case 1 -> {
                // Cuadrado
                int side = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado: "));
                System.out.println("El area del cuadrado es " + Math.pow(side, 2));
            }
            case 2 -> {
                // Rectángulo
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                int height = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                System.out.println("El area del rectángulo es " + (base * height));
            }
            case 3 -> {
                // Triangulo
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                int height = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                System.out.println("El area del triangulo es " + (base * height / 2));
            }
            case 4 -> {
                // Circulo
                int radius = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
                System.out.println("El area del circulo es");
                System.out.printf("%1.2f", Math.pow(radius, 2) * Math.PI);
            }
            default -> System.out.println("La opción introducida no es correcta");}
        // ---------------- //
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