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


public class Video75_15 extends JFrame implements WindowFocusListener{
    public static void main(String[] args) {
        Video75_15 myInstace = new Video75_15();
        myInstace.initialize();
    }
    
    Video75_15 frame1;
    Video75_15 frame2;
    
    public void initialize() {
        frame1 = new Video75_15();
        frame2 = new Video75_15();
        
        frame1.setVisible(true);
        frame2.setVisible(true);
        
        frame1.setBounds(1920 / 2 - 150, 0, 300, 200);
        frame2.setBounds(1920 / 2 - 150, 1080 - 230, 300, 200);
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame1.addWindowFocusListener(this); // El oyente lo declaramos en la misma clase, por eso el this
        frame2.addWindowFocusListener(this);
    }
    
    @Override
    public void windowGainedFocus(WindowEvent e) {
        Video75_15 frame = (Video75_15) e.getSource();
        frame.setTitle("Tengo el foco !"); // Le podemos aplicar este método porque heredamos de JFrame
        /*
        if(e.getSource() == frame1) {
            frame1.setTitle("Tengo el foco !");
        } else { // Como solo esta escuchando dos objetos podemos hacer esto
            frame2.setTitle("Tengo el foco !");
        }
        */
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        Video75_15 frame = (Video75_15) e.getSource();
        frame.setTitle("");
        /*
        if(e.getSource() == frame1) {
            frame1.setTitle("");
        } else { // Como solo esta escuchando dos objetos podemos hacer esto
            frame2.setTitle("");
        }
        */
    }
}

