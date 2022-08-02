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
import java.awt.event.*;
import javax.swing.*;

public class Video87_20 {
    public static void main(String[] args) {
        MyFrame16 window = new MyFrame16();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame16 extends JFrame {
    public MyFrame16() {
        setTitle("Campos de texto");
         
        
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel13 myPanel = new Panel13();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel13 extends JPanel {
    private JTextField textField = new JTextField(20); // Con longitud de unidades (int columns)
    private JButton button = new JButton("Comprobar");
    private JLabel result = new JLabel("", JLabel.CENTER);
       
    public Panel13() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new FlowLayout());
        panel.setSize(10, 10);
        JLabel email = new JLabel("Email:");
        
        panel.add(email);
        button.addActionListener(new actionListener());
        panel.add(textField);     
        panel.add(button);
        
        add(panel, BorderLayout.NORTH);
        add(result,BorderLayout.CENTER);
    }
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userEmail = textField.getText().trim(); // Le quitamos cualquier espaciado al inicio
            boolean arroba = false; // Vamos a suponer que el correo ingresado no la tiene, hasta que demostremos que si
            boolean dot = false; // Vamos a hacer el mismo análisis de arriba 
            
            for(int i = 0; i < userEmail.length(); i++) {
                char character = userEmail.charAt(i);

                if(character == '@') {
                    if(!arroba) { // Si es la primera y única "@"
                        arroba = true;
                    } else {
                        arroba = false;
                        break; // Si encontramos otra "@" detenemos el for con arroba en false
                    } 
                } else if(character == '.') { // Como estamos comparando chars podemos usar "=="
                    if(!dot) {
                        dot = true;        
                    }               
                }
            } 
            
            if(arroba && dot) {
                result.setText("Valido");
            } else {
                result.setText("Invalido");
            }            
        }
        
    }
}