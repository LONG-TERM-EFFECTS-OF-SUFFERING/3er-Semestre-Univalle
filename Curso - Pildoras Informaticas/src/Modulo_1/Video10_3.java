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

public class Video10_3 {
    public static void main(String[] args) {
        double square = Math.sqrt(9); // Este método recibe un double y retorna un double
        // Casos Math.round        
        // Recibe un float - retorna un int        
        float number1 = 5.6f;
        int rounded1 = Math.round(number1);

        // Recibe un double - retorna un long (tiene sentido para numero muy grandes)       
        double number2 = 5.87;
        int rounded2 = (int) Math.round(number2); // Si no lo convertimos no lo podemos almacenar en un int
        // porque retorna un long (tenemos que hacer una refundicion)

        // Math.pow recibe (double, double)       
        int pow = (int) Math.pow(number1, number2); // Hacemos dos fundiciones, para que
        // evitar los errores por tipos (una ya la hace el propio método en "number1")

        System.out.println("El numero 1 es: " + number1 + ", que redondeado es: " + rounded1);
        System.out.println("El numero 1 es: " + number2 + ", que redondeado es: " + rounded2);
        System.out.println("El numero " + number1 + " Elevado a la " + number2 + " es: " + pow);
    }
}
