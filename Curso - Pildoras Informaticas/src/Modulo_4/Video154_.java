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

public class Video154_ {
    public static void main(String[] args) {
        writeFile.write();
        readFile.read();
    }
}

class readFile {
    public static void read() {
        try {
            FileReader fileReader = new FileReader("src/Modulo_4/file.txt"); 
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            
            while(line != null) { // Dentro del while podemos asignar line con la siguiente
                // declaracion (line = bufferedReader.readLine()) != null
                System.out.println(line);
                line = bufferedReader.readLine(); // Mientras lee avanza
            }
            fileReader.close(); // Cuando lo terminamos de usar cortamos el flujo
        } catch (IOException e) { // Es el tipo de excepcion que lanza el metodo read
            System.out.println("No se ha podido leer el archivo");
        }
    }
}

class writeFile {
    public static void write() {
        String[] sentences = {
            "Quiero que esto se escriba en el archivo",
            "Tambien esto"
        };
        try {
            FileWriter fileWriter = new FileWriter("src/Modulo_4/file.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("prueba");
           // for(String line:sentences) {
                //System.out.println(line);
                //bufferedWriter.write(line);
                //bufferedWriter.newLine();
            //}          
            fileWriter.close();
        } catch (IOException e) { // Es el tipo de excepcion que lanza el metodo read
            System.out.println("No se ha podido escribir en el archivo");  
        }
    }
}