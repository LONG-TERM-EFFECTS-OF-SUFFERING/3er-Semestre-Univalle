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

public class Video25_16 {
    public static void main(String[] args) {
        // Vamos a ver matrices (arrays bidimensionales)
        int[][] my2DArray = new int[2] [2]; // 2 columnas x 2 filas (no cuenta el "0")
                               // (y , x)
        my2DArray[0][0] = 1;
        my2DArray[0][1] = 2;
        
        my2DArray[1][0] = 3;
        my2DArray[1][1] = 4;
        
        // Usamos for each
        for(int[] row:my2DArray) { 
            for(int number:row) { 
                System.out.print(number + " "); 
            }
            System.out.println(""); // Dejamos un espacio entre impresion
        }
        // Otra forma de declararla        
        int[][] my2DArray2 = {
        {1, 2, 3},
        {4, 5, 6}
        };
        
        for(int[] row:my2DArray2) { 
            for(int number:row) { 
                System.out.print(number + " "); 
            }
            System.out.println("");
        }        
    }
}
