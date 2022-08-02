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

public class EstructuraBasica {
    public static void main(String[] args) {
        MyFrame5 window = new MyFrame5();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame5 extends JFrame {
    public MyFrame5() {
        setTitle("");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel4 myPanel = new Panel4();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel4 extends JPanel {
    
    public Panel4() {

    }
}