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

public class Video12_4 {
    public static void main(String[] args) {
        // Vamos a empezar a ver los strings
        String name = "Brandon";
        
        System.out.println("Mi nombre es: " + name);       
        System.out.println("Mi nombre tiene " + name.length() + " Letras");    
        System.out.println("La primera letra de " + name + " es " + name.charAt(0));
        
        int lastLetterPosition = name.length();       
        System.out.println("La ultima letra de " + name + " es " + name.charAt(lastLetterPosition - 1));
        // Es - 1 porque se empieza a contar desde el cero
        
        String phrase = "Hoy es un estupendo dia para programar en Java";
        
        String subPhrase = phrase.substring(0, 29); // (comienzo, final)
        
        String newPhrase = subPhrase + "ir a jugar";        
        System.out.println(newPhrase);
        
        Boolean areEqual = phrase.equals("Hoy es un estupendo dia para programar en Java");       
        System.out.println(areEqual);
        
        areEqual = phrase.equals("Hoy es Un estupendo dia para programar en Java"); // Con una sola letra
        // diferente ya retorna false       
        System.out.println(areEqual);
        
        areEqual = phrase.equalsIgnoreCase("Hoy es Un estupendo dia para programar en Java"); // Este ignora
        // si son mayúsculas o minusculas, solo importa el carácter
        System.out.println(areEqual);
    }
}
