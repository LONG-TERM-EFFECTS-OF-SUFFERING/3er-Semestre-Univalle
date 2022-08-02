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


public class Video82_18 {
    public static void main(String[] args) {
        MyFrame15 window = new MyFrame15();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame15 extends JFrame {
    public MyFrame15() {
        setTitle("Layouts");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        Panel10 myPanel = new Panel10();          
        Panel11 myPanel2 = new Panel11();
        // Las ponesmos en diferentes lugares para que no se superpongan
        add(myPanel, BorderLayout.NORTH);
        add(myPanel2, BorderLayout.SOUTH);   
    }
}

class Panel10 extends JPanel {
    
    public Panel10() {
        FlowLayout disposition = new FlowLayout(FlowLayout.LEFT);//, 75, 80); // Java por defecto usa este en .CENTER
        // los argumentos son (tipo, separacion horizontal, separacion vertical)
        //BorderLayout disposition = new BorderLayout(10, 10);
        
        setLayout(disposition);
        
        add(new JButton("Amarillo"));//, BorderLayout.NORTH);
        add(new JButton("Azul"));//, BorderLayout.EAST);

    }
}

class Panel11 extends JPanel {
    // Creamos otro panel para trabajar con otra disposicion
    public Panel11() {
        setLayout(new BorderLayout());
        
        add(new JButton("Rojo"), BorderLayout.EAST);
        add(new JButton("Verde"), BorderLayout.WEST);
        add(new JButton("Negro"), BorderLayout.CENTER);
    }
}