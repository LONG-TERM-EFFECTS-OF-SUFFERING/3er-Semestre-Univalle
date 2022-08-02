package Clase07_07.segundo.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 
public class LecturaArchivoScanner {   
    public static void main(String[] args) {        
        File file = new File("mapita.txt");
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(file);
            while (entrada.hasNext()) {
                System.out.println(entrada.nextInt());                          
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }  
    }
}  

