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

public class InteractiveCoordinates extends JFrame{
    public static void main(String[] args) {
        InteractiveCoordinates myInstance = new InteractiveCoordinates();
        myInstance.initialize();
    }
    
    private JLabel mouseCoordinates;
    
    public void initialize() {
        setTitle("Coordenadas interactivas");
        
        setVisible(true);        
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        mouseCoordinates = new JLabel("Coordenadas");
        add(mouseCoordinates);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(new myMouseListener());
    }

    
    class myMouseListener extends MouseAdapter { // Lo hacemos como clases interna para tener acceso
        // al JLabel
        @Override
        public void mouseMoved(MouseEvent e) {
            mouseCoordinates.setText(("(" + e.getX() + "," + e.getY() + ")"));           
        }
    }
}

