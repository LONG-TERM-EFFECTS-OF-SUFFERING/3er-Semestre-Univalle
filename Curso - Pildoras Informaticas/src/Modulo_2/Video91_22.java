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

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;


public class Video91_22 {
    public static void main(String[] args) {
        MyFrame19 window = new MyFrame19();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame19 extends JFrame {
    private JPanel panel      = new JPanel();
    private JTextArea textArea = new JTextArea(8, 20);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    
    public MyFrame19() {
        setLayout(new BorderLayout());
        setTitle("Probando los JTextArea");              
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        JButton insertButton = new JButton("Insertar");
        insertButton.addActionListener((ActionEvent e) -> {
            textArea.append("Texto de prueba...");                  
        });
        
        JButton lineWrapButton = new JButton("Poner salto"); // Por defecto el lineWrap se crea en false
        lineWrapButton.addActionListener((ActionEvent e) -> {
            boolean wrapLine = !textArea.getLineWrap();
            textArea.setLineWrap(wrapLine);
            /*
            if(wrapLine) {
                lineWrapButton.setText("Quitar salto");
            } else {
                lineWrapButton.setText("Poner salto");
            }
            */
            lineWrapButton.setText(wrapLine ? "Quitar salto" : "Poner salto"); // Operador ternario
        });
        
        panel.add(insertButton);
        panel.add(lineWrapButton);
        
        add(panel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}

