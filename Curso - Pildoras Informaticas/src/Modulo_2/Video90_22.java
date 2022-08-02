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

import javax.swing.*;
import java.awt.event.*;


public class Video90_22 {
    public static void main(String[] args) {
        MyFrame18 window = new MyFrame18();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame18 extends JFrame {
    public MyFrame18() {
        setTitle("Probando los JTextArea");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel15 myPanel = new Panel15();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel15 extends JPanel {
    private JTextArea textArea = new JTextArea(8, 20); // Por defecto cambia de tamaño en funcion del
    // texto que contenga
    
    public Panel15() {                
        textArea.setLineWrap(true); // Evitar que el cuadro se redimensione
        
        JScrollPane scrollPane = new JScrollPane(textArea);       
        
        JButton button = new JButton("Imprimir texto");
        button.addActionListener(new actionListener());
        
        add(scrollPane);
        add(button);
    }
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(textArea.getText());
        }
        
    }
        
}