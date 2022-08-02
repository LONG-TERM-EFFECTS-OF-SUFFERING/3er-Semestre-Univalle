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


public class Video70_11 {
    public static void main(String[] args) {
        MyFrame9 window = new MyFrame9();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame9 extends JFrame {
    public MyFrame9() {
        setTitle("Eventos de ventana");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        MyWindowStateListener listener = new  MyWindowStateListener();
        addWindowStateListener(listener);
    }
}

class MyWindowStateListener implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {
        int newState = e.getNewState();
        System.out.println("La ventana ha cambiado de estado");
        // Ahora hagamos uso de estas constantes de clase
        switch (newState) {
            case Frame.MAXIMIZED_BOTH -> System.out.println("La ventana esta en pantalla completa");
            case Frame.NORMAL -> System.out.println("La ventana esta normal");
            case Frame.ICONIFIED -> System.out.println("La ventana esta minimizada");
            default -> {
            }
        }
    }
    
}
