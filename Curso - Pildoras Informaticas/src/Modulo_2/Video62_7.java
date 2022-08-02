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
import java.awt.GraphicsEnvironment;
import java.awt.geom.*;


public class Video62_7 {
    public static void main(String[] args) {
        /*
        String [] userFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        // Con la linea anterior almacenamos todas los nombres de las fuentes del usuario en un array
        // Ahora hagamos un validador de una fuente ingresada por el usuario
        String userFont = JOptionPane.showInputDialog("Introduce el nombre de una fuente");
        boolean wasTheFontFound = false;
        for(String font:userFonts) {
            if(userFont.equalsIgnoreCase(font)) {
                System.out.println("Fuente encontrada");
                wasTheFontFound = true;
                break;
            }  
        }
        if(!wasTheFontFound) {
            System.out.println("Fuente no encontrada");
        }
        */
        MyFrame5 window = new MyFrame5();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame5 extends JFrame {
    public MyFrame5() {
        setTitle("Coloreando fuentes");
        setVisible(true); 
        
        setSize(400, 400);
        
        // Para centrarlo 
        setLocation(1920 / 2 - 200, 1080 / 2 - 200);
        
        Panel4 myPanel = new Panel4();
        myPanel.setForeground(Color.GREEN); // Para de todo lo que pongamos en el panel
        add(myPanel);   
    }
}

class Panel4 extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Font myFont = new Font("Arial", Font.BOLD, 26);
        g2.setFont(myFont);
        //g2.setColor(Color.CYAN);
        g2.drawString("Juan", 100, 100);
        
        //g2.setColor(Color.RED);
        g2.setFont(new Font("Courier", Font.ITALIC, 26));
        g2.drawString("Curso de Java", 100, 200);
    }
}