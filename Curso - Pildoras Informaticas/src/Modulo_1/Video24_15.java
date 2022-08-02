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

public class Video24_15 {
    public static void main(String[] args) {
        String [] countries = {"España", "México", "Colombia", "Perú", "Chile","Argentina", "Ecuador", "Venezuela"};

        for (String country:countries) {
        System.out.println("País: " + country);
        }
        
        // Para rellenar el array
        for(int i = 0; i < countries.length; i++) {
            countries[i] = JOptionPane.showInputDialog("Introduce el pais " + (i + 1) + ":");
        }
        
        // Mostramos el array actualizada
        for (String country:countries) {
            System.out.println("País: " + country);
        }
        
        // Creemos un array con 25 numero aleatorios de 0 - 100 
        int[] myArray = new int[25];
        
        for(int i = 0; i < 25; i++) {
            int number = (int) (Math.random() * 100);
            myArray[i] = number;
        }
        
        for(int number:myArray) {
            System.out.println(number);
        }
    }
}
