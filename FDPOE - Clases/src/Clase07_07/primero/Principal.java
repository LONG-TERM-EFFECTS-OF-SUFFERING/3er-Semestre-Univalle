package Clase07_07.primero;

import java.io.*;

public class Principal {
    public static void main(String[] args)  {
        // Como hicimos los metodos estaticos no tenemos que instanciar un objeto
        crear();
        abrir();
    }
       
    static void abrir(){
        String path = "src/Clase07_07/primero/texto.txt";
        File file = new File(path);
        FileReader fr = null;
        
        try {
            if(file.exists()) {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while ((linea = br.readLine()) != null) { // Cuando lee avanza a la siguiente linea
                    System.out.println(linea);                    
                }
                
                fr.close();               
            } else {
                System.out.println("Arhivo no existe");
            }
                                                           
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Excepcion " + e.getMessage());
        }
    }
           
    static void crear() {
        String path = "src/Clase07_07/primero/texto.txt";
        File file = new File(path);
        FileWriter fw = null;
        
        try {            
            fw = new FileWriter(file, false); // El segundo parametro corresponde al modo append
            
            for(int i = 1; i < 10; i++) {
                fw.write("Hola : "  + i + "\n");
            }            
            System.out.println("Archivo creado con éxito");          
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
