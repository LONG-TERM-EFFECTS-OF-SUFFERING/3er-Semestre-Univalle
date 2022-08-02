package Clase14_07;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Window extends JFrame {
    JScrollPane scrollPane; 
    JTextArea fileText;
    JButton btnOpen ;
    JButton btnSearch;
    JButton btnExit ;
    JTextField txtElementToSearch;
    Map<String,Integer> words;
    
    public Window() {
        super("Files manager"); // Si el contructor recibe un String, este sera el titulo
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);
        setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints(); // Vamos a cambiar sus propiedades
        // para usarlo en todos los elementos de la interfaz

        fileText = new JTextArea();
        scrollPane = new JScrollPane(fileText);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        // El area de texto debe estirarse hacia ambos lados
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        add(scrollPane, constraints);
        // Lo restauramos
        constraints.fill = GridBagConstraints.NONE;
        
        btnOpen   = new JButton("Abrir");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTH;        
        add(btnOpen, constraints);
        
        // Restauramos valores por defecto
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 0.0;    

        btnSearch = new JButton("Buscar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(btnSearch, constraints);
        
        btnExit   = new JButton("Salir");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        btnSearch.setEnabled(false);
        add(btnExit, constraints);

        txtElementToSearch = new JTextField("Palabra o letra a buscar");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        // El campo de texto solo se estira horizontalmente
        constraints.fill = GridBagConstraints.HORIZONTAL;
        txtElementToSearch.setEnabled(false);
        add(txtElementToSearch, constraints);
                                         
        btnExit.addActionListener(new actionListener());
        btnOpen.addActionListener(new actionListener());
        btnSearch.addActionListener(new actionListener());
             
        setVisible(true); // Si lo hacemos visible antes de agregar todo, no se vera lo que agregamos
     }
    
    private File getFileOrDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt"); // Alias, extension
        
        fileChooser.setFileFilter(filter);
            
        //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); No es necesario,
        // por defecto ya se crea con este modo
        
        // Hasta que no se cierra la ventana del File Choose la ejecucion no pasa de esta linea
        int result = fileChooser.showOpenDialog(this);

        if(result == JFileChooser.CANCEL_OPTION) return null;
         
        File fileName = fileChooser.getSelectedFile();

        if((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            
            System.exit(1);
        }
      return fileName;
   } 
    
    private void showError(File name){
        JOptionPane.showMessageDialog(this, name + " doesn't exist.", "ERROR", JOptionPane.ERROR_MESSAGE);                 
    }
    
    private void loadContent(File name) {
        words = new HashMap();
        words = readFile(name);
        
        for(Map.Entry<String,Integer> entry:words.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            System.out.println(key + "->" + value);            
        }
     }
     
    private Map<String,Integer> readFile(File name) {
        // Vamos a gestionar la informacion con un map de String - Int (Integer)       
        FileReader fileReader;
        Map<String,Integer> palabras = new HashMap();
        
        try {
            if(name.exists()) {
                fileReader = new FileReader(name, Charset.forName("UTF-8"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                StringTokenizer stringTokenizer;
                int linesNumber = 0;
                String text = "";
                
                while((linea = bufferedReader.readLine()) != null) {
                    text += linea + "\n"; // Con este mostramos el texto en el label
                    stringTokenizer = new StringTokenizer(linea);
                    linesNumber++;
                    while(stringTokenizer.hasMoreTokens()) {
                        String palabra = stringTokenizer.nextToken().toLowerCase();
                        
                        if(!palabras.containsKey(palabra)) {
                            palabras.put(palabra, 1);
                        } else {
                            palabras.replace(palabra, palabras.get(palabra) + 1);
                        }                    
                    }                    
                }
                palabras.put("totalLineas", linesNumber); // Agregamos la ultima key - value
                fileText.setText(text);
                txtElementToSearch.setText("");
                btnSearch.setEnabled(true);
                txtElementToSearch.setEnabled(true);
                fileReader.close();                
            } else {
                System.out.println("Arhivo no existe");
            }
                                                           
        } catch(FileNotFoundException ex) {
            System.out.println("Excepcion " + ex.getMessage());
        } catch(IOException e) {
            System.out.println("Excepcion " + e.getMessage());
        }
        return palabras;
    }
     
     private void searchElement() {
        String word = txtElementToSearch.getText().toLowerCase().trim(); // Con las mismas letras
        // no exactamente igual
        
        if(fileText.getText().length() > 0) {
            if(word.length() == 1) { // Significa que es una letra
                String wordsList = "";
                char letter = word.charAt(0);
                int total = 0;
                
                for(Map.Entry<String,Integer> entry:words.entrySet()) {
                    String entryKey = entry.getKey();
                    char firstLetterEntry = entryKey.charAt(0);
                                        
                    if(firstLetterEntry == letter) {
                        int wordNumber = entry.getValue(); // Solo si coincide, lo sumamos
                        wordsList += entryKey + "\n";
                        total += wordNumber;
                    }
                }
                JOptionPane.showMessageDialog(this, "Aparece:" + total + " veces");
                JOptionPane.showMessageDialog(this, "En las palabras " + wordsList);
            } else {
                int total = words.get(word);
            
                JOptionPane.showMessageDialog(this, "Aparece:" + total + " veces");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay texto");
        }        
     }
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnExit) {
                dispose();
            } else if(e.getSource() == btnOpen) {
                File name = getFileOrDirectory();
             
                if(name != null) {                            
                    if (name.exists()) {
                        loadContent(name);
                    } else {              
                        showError(name); // file doesn't exist
                    }
                }  
            } else if(e.getSource() == btnSearch) {
                searchElement();
            }
        }
    }          
}


