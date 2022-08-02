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



public class Video58_4 {
    public static void main(String[] args) {
        MyFrame2 window = new MyFrame2();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame2 extends JFrame {
    public MyFrame2() {
        setVisible(true); // Como lo estamos poniendo en el contractor la referencia hacia el objeto
        // ya esta
        
        setSize(600, 400);
        
        // Para centrarlo 
        setLocation(1920 / 2 - 300, 1080 / 2 - 200);
        
        Panel myPanel = new Panel();
        add(myPanel); // Agregamos nuestro panel
    }
}

class Panel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); // Este método es de JComponent
        g.drawString("Aprendiendo Swing", 100, 100); // Los últimos dos parámetros son la ubicación en "x" y "y"
    }
}