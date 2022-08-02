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
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class Video92_23 {
    public static void main(String[] args) {
        MyFrame20 window = new MyFrame20();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame20 extends JFrame {
    public MyFrame20() {
        setTitle("Probando los CheckBox");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel16 myPanel = new Panel16();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel16 extends JPanel {
    private JLabel text = new JLabel("En un lugar de la Mancha de cuyo nombre...");
    // En los constructores de los CheckBox podemos introducir un String (que va a aparecer al lado)
    private JCheckBox checkBox1 = new JCheckBox("Negrita"), checkBox2 = new JCheckBox("Cursiva");
    
    public Panel16() {
        setLayout(new BorderLayout());
        
        Font myFont = new Font("Serif", Font.PLAIN, 18);
        
        text.setFont(myFont);
        
        add(text, BorderLayout.CENTER);
        
        JPanel checkBoxes = new JPanel();
        
        checkBox1.addActionListener(new actionListener());
        checkBox2.addActionListener(new actionListener());
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        
        add(checkBoxes, BorderLayout.SOUTH);
    }
    
    private class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int type = 0;
            
            if(checkBox1.isSelected()) type += Font.BOLD;
            if(checkBox2.isSelected()) type += Font.ITALIC;
            
            text.setFont(new Font("Serif", type, 18)); // Aprovechamos que el tipo italico y negrilla
            // es la suma de los estilos individuales
        }
        
    }
}