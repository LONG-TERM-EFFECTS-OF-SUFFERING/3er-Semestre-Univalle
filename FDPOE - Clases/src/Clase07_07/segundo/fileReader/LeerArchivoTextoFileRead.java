package Clase07_07.segundo.fileReader;

import java.io.*;


class LeerArchivoTextoFileRead {        
    public static void main(String[] args) {      
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
     
        try {
            /* Apertura del fichero y creacion de BufferedReader para poder
            hacer una lectura comoda (disponer del metodo readLine()).
            //archivo = new File ("c://prueba.txt"); */
            archivo = new File ("mapa.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
                 
      
            // Lectura del fichero
            String linea;
              
//         while((fr.read())!=-1){
//                  System.out.println(fr.read());
//         }
         
        while((linea = br.readLine()) != null){
            System.out.println(linea);
        }
       
        } catch(IOException ioe) {
            System.out.println("Ha ocurrido un error");
        } finally {
        /* 
        En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien 
        como si aparece una excepcion
        */
        try {                   
            if(null != fr){  
               fr.close();    
            }                 
        } catch (Exception e2){
            System.out.println("Ha ocurrido un error");
        }
      }
   }
}