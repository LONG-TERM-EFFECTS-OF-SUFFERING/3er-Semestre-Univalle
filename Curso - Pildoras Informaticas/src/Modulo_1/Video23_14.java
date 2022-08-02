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

public class Video23_14 {
    public static void main(String[] args) {
        // Vamos a ver la declaración de arrays   
        // 1er forma:
        int[] myArray1 = new int[5];
        
        myArray1[0] = 1;
        myArray1[1] = 2;
        myArray1[2] = 3;
        myArray1[3] = 4;
        myArray1[4] = 5;

        // 2da forma:
        int[] myArray2 = {1, 2, 3 , 4, 5};
        
        for(int i = 0; i < myArray1.length; i++) {
            System.out.println("Valor del indice "+ i + " es " + myArray1[i]);
            System.out.println("Valor del indice "+ i + " es " + myArray2[i]);
        } 
    }
}
