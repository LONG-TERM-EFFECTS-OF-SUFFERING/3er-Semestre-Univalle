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

package Modulo_4;

import java.io.*;

public class Video153_ {
    public static void main(String[] args) {
        writeFile.write();
        readFile.read();
    }
}

class readFile {
    public static void read() {
        try {
            FileReader fileReader = new FileReader("src/Modulo_4/file.txt"); // Como segundo argumento
            // recibe un boolean que indica si se abre en modo append o no
            
            int characterCode = fileReader.read();
            
            while(characterCode != -1) {               
                System.out.println("Codigo: " + characterCode + " que corresponde a la letra " + (char) characterCode);
                characterCode = fileReader.read(); // Mientras lee avanza
            }
            fileReader.close(); // Cuando lo terminamos de usar cortamos el flujo
        } catch (IOException e) { // Es el tipo de excepcion que lanza el metodo read
            System.out.println("No se ha podido leer el archivo");
        }
    }
}

class writeFile {
    public static void write() {
        String sentence = "Quiero que esto se escriba en el archivo";
        try {
            FileWriter fileWriter = new FileWriter("src/Modulo_4/file.txt");
            
            for(int i = 0; i < sentence.length(); i++) {
                fileWriter.write(sentence.charAt(i));
            }
            fileWriter.close();
        } catch (IOException e) { // Es el tipo de excepcion que lanza el metodo read
            System.out.println("No se ha podido escribir en el archivo");  
        }
    }
}