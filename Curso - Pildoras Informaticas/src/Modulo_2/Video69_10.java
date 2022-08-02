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

public class Video69_10 {
    public static void main(String[] args) {
        MyFrame8 window = new MyFrame8();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esto cierra abruptamente el programa
        window.setBounds(1920 / 2 - 200, 1080 / 2 - 100, 300, 200);
        
        MyFrame8 window2 = new MyFrame8();
        window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window2.setBounds(1920 / 2 + 200, 1080 / 2 - 100, 300, 200);
    }
}

class MyFrame8 extends JFrame {
    public MyFrame8() {
        setTitle("Eventos de ventana");
        setVisible(true); 
        
        //setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        MyWindowListener listener = new MyWindowListener();
        addWindowListener(listener); // Va a escuchar a la ventana, también podemos addWindowListener(new MyWindowListener());
    }
}
/*
class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando ventana");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Ventana cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana restaurada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana inactiva");
    }
}
*/
class MyWindowListener extends WindowAdapter {
    // Estamos heredando de una clase que ya tiene estos métodos, asi que si queremos usar uno
    // lo estamos sobrescribiendo
    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana activa");
    }  
}
