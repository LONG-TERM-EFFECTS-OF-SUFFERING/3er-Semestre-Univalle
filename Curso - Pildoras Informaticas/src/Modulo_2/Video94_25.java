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
import java.awt.event.*;


public class Video94_25 {
    public static void main(String[] args) {
        MyFrame22 window = new MyFrame22();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame22 extends JFrame {
    public MyFrame22() {
        setTitle("");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel18 myPanel = new Panel18();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel18 extends JPanel {
    private JLabel text = new JLabel("En un lugar de la mancha de cuyo nombre...");
    private JRadioButton button1 = new JRadioButton("Pequeño"), button2 = new JRadioButton("Mediano"), 
            button3 = new JRadioButton("Grande"), button4 = new JRadioButton("Muy grande");
    ButtonGroup group1 = new ButtonGroup();
    JPanel panel = new JPanel();
    
    public Panel18() {
        setLayout(new BorderLayout());
        
        text.setFont(new Font("Serif", Font.PLAIN, 12));
        add(text, BorderLayout.CENTER);
        
        JRadioButton[] buttons = {button1, button2, button3, button4}; // Estan ordenanos
        addButtons(buttons);
        
    }

    private void addButtons(JRadioButton[] buttons) {
        int size = 13;        
        for(JRadioButton button:buttons) {
            size += 2;
            final int finalSize = size; // Requisito para referenciar variables en expresiones lambda
            // y clases internas
            button.addActionListener((ActionEvent e) -> {                               
                text.setFont(new Font("Serif", Font.PLAIN, finalSize));
            });

            group1.add(button);
            panel.add(button);         
        }
        add(panel, BorderLayout.SOUTH);
    }
    /*    
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);
        group1.add(button4);
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        
        add(panel, BorderLayout.SOUTH);
    }
    
    private class actionListener implements ActionListener {       
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton pressedButton = (JRadioButton) e.getSource();
            
            if(pressedButton == button1) {
                text.setFont(new Font("Serif", Font.PLAIN, 14));
            } else if(pressedButton == button2) {
                text.setFont(new Font("Serif", Font.PLAIN, 16));
            } else if(pressedButton == button3) {
                text.setFont(new Font("Serif", Font.PLAIN, 18));
            } else { // Caso button4
                text.setFont(new Font("Serif", Font.PLAIN, 20));
            }
        }
        
    }
    */
}