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

package ejercicios;

public class Video8_2 {
    
    public static void main(String[] args){
        
        final float dolar = 1.137f; // Tasa de conversion 
        
        final float salario = 2125.70f; // En otra moneda
        
        float salarioEnDolares = salario / dolar;
        
        String nombre = "Manuel";
        
        System.out.println("El salario en dolares de " + nombre + " es: $" + salarioEnDolares);
    }        
}
