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

import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;


public class Video74_14 {
    public static void main(String[] args) {
        MyFrame12 window = new MyFrame12();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame12 extends JFrame {
    public MyFrame12() {
        setTitle("Eventos de foco");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        Panel7 myPanel = new Panel7();       
        add(myPanel);   
    }
}

class Panel7 extends JPanel {
    JTextField textField1;
    JTextField textField2;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        setLayout(null); // Invalidamos la disposición que le da java a los objeto por defecto
        
        textField1 = new JTextField();
        textField2 = new JTextField();
        
        textField1.setBounds(150 - 25, 0, 50, 20);
        textField2.setBounds(150 - 25, 200 - 60, 50, 20);
        
        g.drawLine(0, 200, 300, 200);
        
        add(textField1);
        add(textField2);
        
        textField1.addFocusListener(new MyFocusListener());
    }
    
    private class MyFocusListener implements FocusListener { // Lo hicimos como clase interna para poder
        // acceder a esos campos de texto que creamos

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("El primer cuadro ha ganado el foco");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("El primer cuadro ha perdido el foco");
            
            String email = textField1.getText();
            
            boolean arroba = false; // Vamos a suponer que el correo ingresado no la tiene, hasta que demostremos que si
            boolean punto = false; // Vamos a hacer el mismo análisis de arriba  

            for(int i = 0; i < email.length(); i++) {
                char caracter = email.charAt(i);

                if(caracter == '@') {
                    if(!arroba) { // Si es la primera y única "@"
                        arroba = true;
                    } else {
                        arroba = false;
                        break;
                    } 
                } else if (caracter == '.') {
                    punto = true;
                } else if (arroba && punto) break;
            }   
            System.out.println(arroba && punto);   
        }     
    }
}