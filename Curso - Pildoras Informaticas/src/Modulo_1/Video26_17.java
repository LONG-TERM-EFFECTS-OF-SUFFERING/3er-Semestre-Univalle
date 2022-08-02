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

public class Video26_17 {
    public static void main(String[] args) {
        // Vamos a pasar una tabla de excel a una matriz (con su lógica)       
        double acumulate = 10000;
        int interest;         
        // Hacemos la matriz correspondiente       
        double[][] salary = new double[5][6]; // 5 filas x 6 columnas
        
        /*
        Vamos a tratar de hacer la lista como muestra el excel, la otra forma es hacer cada interés
        en una fila y luego a la hora de imprimirlo invertimos filas x columnas (asi también se
        mostraría como en la tabla)
        */
        
        // LLenamos la primer fila con el valor inicial
        for(int i = 0; i < 6; i++) {
            salary[0][i] = 10000;
        }
        
        for(int i = 1; i < 5; i++) { // Ya tenemos la primer fila
            interest = 10;
            
            for(int j = 0; j < 6; j++) {
                acumulate = salary[i - 1][j]; // El acumulado es el que esta una fila arriba
                acumulate += acumulate * interest / 100;
                salary[i][j] = acumulate;               
                interest++;                
            }
        }

        // Imprimimos la matriz
        for(double[] row:salary) { 
            for(double number:row) { 
                System.out.printf("%1.2f", number);
                System.out.print(" ");
            }         
            System.out.println("");
        }
        
        System.out.println("");
        
        double[][] salary2 = new double[6][5]; // 6 filas x 5 columnas       
        interest = 10;
        
        // Ahora veamos la otra forma       
        for(int i = 0; i < 6; i++) {
            acumulate = 10000;           
            salary2[i][0] = acumulate;
            
            for(int j = 1; j < 5; j++) {               
                acumulate += acumulate * interest / 100;
                salary2[i][j] = acumulate;    
            }          
            interest++;
        }       
        // Imprimimos la matriz
        for(double[] row:salary2) { 
            for(double number:row) { 
                System.out.printf("%1.2f", number);
                System.out.print(" ");
            }
            System.out.println("");
        }        
        System.out.println("");    

        // Como vemos salen la filas intercambiadas con las columnas, para arreglar eso:
        // imprimimos la matriz transpuesta(5 filas x 6 columnas)        
        for(int i = 0; i < 5; i++) { 
            for(int j = 0 ; j < 6; j++) {
                System.out.printf("%1.2f", salary2[j][i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}    
