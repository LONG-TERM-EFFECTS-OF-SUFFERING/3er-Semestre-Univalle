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
import java.util.ArrayList;

public class Video155_ {
    
    
    public static void main(String[] args) {
        writeBytesFile.writeFile(readBytesFile.readFile());
    }
}

class readBytesFile {
    static ArrayList<Integer> imageBytes = new ArrayList();
    
    public static ArrayList<Integer> readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/Modulo_2/icon.jpg");
            
            int inputByte = fileInputStream.read(); // Mientras lee avanza
            
            while(inputByte != -1) {
                imageBytes.add(inputByte);
                inputByte = fileInputStream.read();
            }
            System.out.println(imageBytes.size());
            
            
        } catch(IOException e) {
            System.out.println("Ha ocurrido un error al leer la imagen");
        }
        return imageBytes;        
    }
}

class writeBytesFile {
    public static void writeFile(ArrayList<Integer> imageBytes) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Modulo_4/icon_copy.jpg");
            
            for(int imageByte:imageBytes) {
                fileOutputStream.write(imageByte); // Mientras escribe avanza
            }
            fileOutputStream.close();
        } catch(IOException e) {
            System.out.println("Ha ocurrido un error al copiar la imagen");
        }
         
    }
}