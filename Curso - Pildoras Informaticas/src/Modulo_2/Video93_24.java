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

import java.awt.GridLayout;
import javax.swing.*;

public class Video93_24 {
    public static void main(String[] args) {
        MyFrame21 window = new MyFrame21();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame21 extends JFrame {
    public MyFrame21() {
        setTitle("Probando los RadioButton");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel17 myPanel = new Panel17();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel17 extends JPanel {
    
    public Panel17() {
        setLayout(new GridLayout(2, 1));
        
        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();
        
        JRadioButton button1 = new JRadioButton("Amarillo");
        JRadioButton button2 = new JRadioButton("Azul");
        JRadioButton button3 = new JRadioButton("Rojo");
        
        JRadioButton button4 = new JRadioButton("Si");
        JRadioButton button5 = new JRadioButton("No");
        
        // Cuando manejamos grupos solo uno de los botones puede seleccionarse
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);
        
        group2.add(button4);
        group2.add(button5);
        
        // Agregamos los botones al panel, no el grupo
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }
}