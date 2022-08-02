package Clase07_07.segundo.chooser;
// Demonstrating JFileChooser
import java.awt.BorderLayout;
import java.io.File;
import java.text.DateFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FileChooserDemonstration extends JFrame {
   private JTextArea outputArea; // Used for output
   private JScrollPane scrollPane; // Used to provide scrolling to output
   
   // Initialize GUI
   public FileChooserDemonstration() {
      super("Testing class File");

      outputArea = new JTextArea();

      // Add outputArea to scrollPane
      scrollPane = new JScrollPane(outputArea); 

      add(scrollPane, BorderLayout.CENTER); // Add scrollPane to GUI

      setSize(400, 400); // Set GUI size
      setVisible(true); // Display GUI

      analyzePath(); // Create and analyze File object
   }

   // Allow user to specify file or directory name
   private File getFileOrDirectory() {
      // Display file dialog, so user can choose file or directory to open
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

      int result = fileChooser.showOpenDialog(this);

      // if user clicked Cancel button on dialog, return
      if (result == JFileChooser.CANCEL_OPTION)
         System.exit(1);

      File fileName = fileChooser.getSelectedFile(); // Get File

      // Display error if invalid
      if ((fileName == null) || (fileName.getName().equals(""))) {
         JOptionPane.showMessageDialog(this, "Invalid Name",
            "Invalid Name", JOptionPane.ERROR_MESSAGE );
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
      //System.out.println("DateFormat :" + df.format(name.length()));

      if(name.exists()) { // If name exists, output information about it      
         // Display file (or directory) information
         outputArea.setText(String.format(
            "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", // Forma de mostrar la informacion
            name.getName(), " exists", // primera s
            (name.isFile() ? "is a file" : "is not a file" ),
            (name.isDirectory() ? "is a directory" : "is not a directory" ),
            (name.isAbsolute() ? "is absolute path" : "is not absolute path"), 
            "Last modified: ", df.format(name.lastModified()), "Length: ", name.length(), 
            "Path: ", name.getPath(), "Absolute path: ", name.getAbsolutePath(), "Parent: ", name.getParent()));

         if(name.isDirectory()) { // Output directory listing         
            String[] directory = name.list();
            outputArea.append("\n\nDirectory contents:\n");
   
            for (String directoryName : directory)
               outputArea.append(directoryName + "\n");
         } 
      } else {
         JOptionPane.showMessageDialog(this, name + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
      }  
   }
} 
