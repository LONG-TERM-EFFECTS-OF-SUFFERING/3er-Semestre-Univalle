package Clase07_07.segundo.escribirArchivoTexto;

import java.io.*;
 
public class EscribirArchivoTexto {
    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombreArchivo = "pruebaTexto.txt";
        File archivo = new File(nombreArchivo);
        
        try {
            fichero = new FileWriter(archivo, true);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
            System.out.println("Se guardó la información con éxito en el archivo: pruebitaTexto.txt");
 
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información en al archivo");
        } finally {
           try {
           // Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
               System.out.println("Ha ocurrido un error");
           }
        }
    }
}