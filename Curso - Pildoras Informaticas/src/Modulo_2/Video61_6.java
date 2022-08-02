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
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.*;


public class Video61_6 {
        public static void main(String[] args) {
        MyFrame4 window = new MyFrame4();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame4 extends JFrame {
    public MyFrame4() {
        setTitle("Coloreando");
        setVisible(true); 
        
        setSize(400, 400);
        
        // Para centrarlo 
        setLocation(1920 / 2 - 200, 1080 / 2 - 200);
        
        Panel3 myPanel = new Panel3();
        myPanel.setBackground(Color.GREEN); // Para cambiar el color del fondo de la ventana
        add(myPanel);   
    }
}

class Panel3 extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Dibujamos un rectángulo
        Rectangle2D rectangle = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(Color.RED);
        g2.fill(rectangle);
        
        // Dibujamos la elipse
        Ellipse2D ellipse = new Ellipse2D.Double(); 
        ellipse.setFrame(rectangle);
        g2.setPaint(new Color(0, 0 , 255)); // Seria lo mismo que poner Color.BLUE
        // También están los métodos brighter o darker, que hacen lo que sus nombres dicen
        g2.fill(ellipse);
    }
}