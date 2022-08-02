package Clase07_07.segundo.chooser;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileFilterChooser extends JFrame {
   private JTextArea    outputArea; // Used for output
   private JScrollPane  scrollPane; // Used to provide scrolling to output
   
   // Initialize GUI
   public FileFilterChooser() {
      super("Testing class File");

      outputArea = new JTextArea();
      // Add outputArea to scrollPane
      scrollPane = new JScrollPane( outputArea ); 

      add( scrollPane, BorderLayout.CENTER); // add scrollPane to GUI

      setSize(400, 400); // Set GUI size
      setVisible(true); // Display GUI

      //analyzePath(); // create and analyze File object
      
      guardarArchivo();
   }

   // Allow user to specify file or directory name
    private File getFileOrDirectory() {
        // display file dialog, so user can choose file or directory to open
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fileChooser.setFileFilter(filtro);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

        int result = fileChooser.showOpenDialog(this);

        // If user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        File fileName = fileChooser.getSelectedFile(); // Get File

        // Display error if invalid
        if ((fileName == null) || (fileName.getName().equals(""))) {      
            JOptionPane.showMessageDialog( this, "Invalid Name", "Invalid Name", 
            JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } 
        return fileName;
    }

   // Display information about file or directory user specifies
   public void analyzePath() {
   
        // Create File object based on user input
        File name = getFileOrDirectory();
      
        // Formato de fecha 
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        //System.out.println("DateFormat " + df.format(name.length()));

        if (name.exists()) { // If name exists, output information about it     
            // Display file (or directory) information
            outputArea.setText( String.format(
            "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
            name.getName(), " exists",
            (name.isFile() ? "is a file":"is not a file" ),
            (name.isDirectory() ? "is a directory":"is not a directory" ),
            ( name.isAbsolute() ? "is absolute path" : "is not absolute path" ), "Last modified: ",
            df.format(name.lastModified()), "Length: ", name.length(), 
            "Path: ", name.getPath(), "Absolute path: ",
            name.getAbsolutePath(), "Parent: ", name.getParent()));   
      } else { // Not file or directory, output error message     
            JOptionPane.showMessageDialog( this, name +" does not exist.", "ERROR", 
            JOptionPane.ERROR_MESSAGE );
      }   
   }
     
   private void guardarArchivo() {
    try {
        String nombre = "";
        JFileChooser file = new JFileChooser();
        file.showSaveDialog(this);
        File guarda = file.getSelectedFile();

        if(guarda != null) {           
            // Guardamos el archivo y le damos el formato directamente,
            FileWriter save = new FileWriter(guarda + ".txt");
            outputArea.setText("Hola!!! \n esto es un texto que se va a guardar en un archivo de texto en una ubicación dada");
            save.write(outputArea.getText());
            save.close();
            JOptionPane.showMessageDialog(null, "El archivo se ha guardado Exitosamente", "Información"
            ,JOptionPane.INFORMATION_MESSAGE);
        }
    } catch(IOException ex) {
        JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia"
        ,JOptionPane.WARNING_MESSAGE);
    }
 }
 
   public static void main(String[] args){
       FileFilterChooser obf = new FileFilterChooser();
       
       obf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }     
} 
