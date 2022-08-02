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
import java.awt.geom.*;


public class Video60_5 {
        public static void main(String[] args) {
        MyFrame3 window = new MyFrame3();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame3 extends JFrame {
    public MyFrame3() {
        setTitle("Dibujando");
        setVisible(true); 
        
        setSize(640, 640);
        
        // Para centrarlo 
        setLocation(1920 / 2 - 300, 1080 / 2 - 300);
        
        Panel2 myPanel = new Panel2();
        add(myPanel);
    }
}

class Panel2 extends JPanel { // Hay que tener cuidado con el nombre de las clases, ya que están en
    // el mismo paquete
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        /*
        g.drawRect(50, 50, 200, 200); // Los primero dos parámetros hacen referencia a donde se ubicara
        // el top-left del rectángulo
        g.drawLine(100, 100, 200, 300); // Para dibujar una linea necesitamos dos puntos
        */
        
        Graphics2D g2 = (Graphics2D) g; // Hacemos casting
        Rectangle2D rectangle = new Rectangle2D.Double(300 - 50, 320 - 50, 100, 100); // Hay dos tipos de rectangulos
        // los que reciben como argumentos doubles o floats
        
        g2.draw(rectangle); // Dibujamos el rectángulo
        
        // Para dibujar una elipse debemos usar antes un frame (el rectángulo en nuestro caso)
        Ellipse2D ellipse = new Ellipse2D.Double(); // También hay dos elipses
        ellipse.setFrame(rectangle);
        g2.draw(ellipse);
        
        g2.draw(new Line2D.Double(300, 0, 300, 640));
        g2.draw(new Line2D.Double(0, 320, 640, 320));
        
        double XCenter = rectangle.getCenterX();
        double YCenter = rectangle.getCenterY();
        double radio = 320;
        System.out.println("(" + XCenter + ", " + YCenter + ")");
        
        
        g2.draw(new Line2D.Double(50, 0, 50, 640));
        g2.draw(new Line2D.Double(0, 100, 640, 100));
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(XCenter, YCenter, 50, 100 );//XCenter + radio, YCenter + radio);
        g2.draw(circle);
    }
}