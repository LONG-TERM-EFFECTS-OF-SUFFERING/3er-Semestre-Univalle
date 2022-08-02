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


public class Video71_12 {
    public static void main(String[] args) {
        MyFrame10 window = new MyFrame10();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame10 extends JFrame {
    public MyFrame10() {
        setTitle("Eventos con teclado");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        addKeyListener(new MyKeyListener());  
    }
}

class MyKeyListener implements KeyListener {
    
    @Override
    public void keyTyped(KeyEvent e) { // Cuando presiono y suelto
        char letter = e.getKeyChar();
        System.out.println(letter);
    }

    @Override
    public void keyPressed(KeyEvent e) { // Cuando presiono
        int keyCode = e.getKeyCode();
        System.out.println(keyCode); // Mostramos en consola el código de la tecla presionada
    }

    @Override
    public void keyReleased(KeyEvent e) { // Cuando suelto
        
    }

}