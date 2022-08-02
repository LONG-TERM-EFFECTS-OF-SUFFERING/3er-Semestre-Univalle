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


public class Video73_13 {
    public static void main(String[] args) {
        MyFrame11 window = new MyFrame11();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame11 extends JFrame {
    public MyFrame11() {
        setTitle("Eventos con el raton");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }
}
/*
class MyMouseListener implements MouseListener { // Los métodos también están en la clase adaptadora MouseAdapter

    @Override
    public void mouseClicked(MouseEvent e) { // Cuando se presiona y se suelta
        System.out.println("Se ha hecho clic");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Se ha presionado el clic");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Se ha soltado el clic");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Acabas de entrar");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Acabas de salir");
    }  
}
*/
class MyMouseListener extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) { 
        //System.out.println("(" + e.getX() + "," + e.getY() + ")"); // Cada vez que hagamos click las 
        // coordenadas se muestran en pantalla
        int buttonPressed = e.getModifiersEx();
        switch (buttonPressed) {
            case MouseEvent.BUTTON1_DOWN_MASK -> // Esa constante corresponde a 1024
                System.out.println("Se presiono el clic izquierdo");
            case MouseEvent.BUTTON2_DOWN_MASK -> System.out.println("Se presiono la rueda del ratón");
            case MouseEvent.BUTTON3_DOWN_MASK -> System.out.println("Se presiono el clic derecho");
            default -> System.out.println("No se cual estas presionando !");
        }
    }
}

class MyMouseMotionListener implements MouseMotionListener { // Para el movimiento
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("El ratón se esta arrastrando");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("El ratón se esta moviendo");
    }
}