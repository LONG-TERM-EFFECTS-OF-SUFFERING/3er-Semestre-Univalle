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

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Video159_ {
    static File file = new File("src" + File.separator); // Puede manejar tanto archivos como directorios
    // El File.separator nos pone la separacion ("/" o "\") de acuerdo el entorno donde se ejecute 
    // el programa
    public static void main(String[] args) {
        
        //String[] fileList = file.list();
        
        //System.out.println(file.getAbsoluteFile());
        
        //showFileList(fileList);
        //createNewFileOrDirectory("prueba.txt", 0);
        createNewFileOrDirectory("nuevo_directorio", 1);
    }
    
    public static void showFileList(String[] fileList) {       
        for(String currentFile:fileList) {
            System.out.println(currentFile);
            File file2 = new File(file, currentFile); // En este constructor los argumentos correspondes a
            // parent - child, combinando las rutas
            if(file2.isDirectory()) {
                String[] subFileList = file2.list();
                
                showFileList(subFileList); // Recursion
            }
        }
    }
    
    public static void createNewFileOrDirectory(String elementName, int mode) {
        file = new File(file, "Modulo_4/" + elementName); // Debe ser en la primera ejecucion, para
        // que la nueva ruta no se superponga "src/Modulo_4/Modulo_4..."
        
        if(mode == 0) { // File mode                  
            try {
                file.createNewFile();
            } catch(IOException e) {
                System.out.println("Ha ocurrido un error al crear el archivo");
            }
        } else { // Directoy mode
            file.mkdir();
        }
        JOptionPane.showMessageDialog(null, "El archivo sera borrado cuando cierre esta ventana");
        
        file.delete();             
    }
}
