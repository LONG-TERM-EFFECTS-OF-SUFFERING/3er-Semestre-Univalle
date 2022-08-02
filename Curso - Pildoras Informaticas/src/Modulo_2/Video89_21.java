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

package Modulo_2;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;

public class Video89_21 {
    public static void main(String[] args) {
        MyFrame17 window = new MyFrame17();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame17 extends JFrame {
    public MyFrame17() {
        setTitle("Eventos en un JTextField");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel14 myPanel = new Panel14();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel14 extends JPanel {
    private JLabel userLabel = new JLabel("User");
    private JLabel passwordLabel = new JLabel("Password");      
    private JTextField userField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    
    public Panel14() {
        setLayout(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(2, 2));
        
        Document document = passwordField.getDocument(); // Al igual que hacemos con los JTextField
        document.addDocumentListener(new documentListener());
             
        JButton send = new JButton("Enviar");
        
        top.add(userLabel);
        top.add(userField);
        top.add(passwordLabel);
        top.add(passwordField);
        
        add(top, BorderLayout.NORTH);

        add(send, BorderLayout.SOUTH);
    }
    
    private void checkLength(char[] password) {
        int length = password.length;
        
        if(length < 8 || length > 12) {
            passwordField.setBackground(Color.RED);
        } else {
            passwordField.setBackground(Color.WHITE);
        }     
    }
    
    private class documentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) { // Cuando se ingresa texto 
            System.out.println("Se ha ingreado texto");
            checkLength(passwordField.getPassword());
        }

        @Override
        public void removeUpdate(DocumentEvent e) { // Cuando se borra texto
            System.out.println("Se ha borrado texto");
            checkLength(passwordField.getPassword());
        }

        @Override
        public void changedUpdate(DocumentEvent e) { // Cuando se cambian las propiedades del texto
            
        }
        
    }
}