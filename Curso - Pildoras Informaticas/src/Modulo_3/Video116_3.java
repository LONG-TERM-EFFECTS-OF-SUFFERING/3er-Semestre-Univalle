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

package Modulo_3;

import javax.swing.*;

public class Video116_3 {
    public static void main(String[] args) {
        MyFrame30 window = new MyFrame30();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame30 extends JFrame {
    public MyFrame30() {
        setTitle("Probando el SpringLayout");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel23 myPanel = new Panel23();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel23 extends JPanel {
    
    public Panel23() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JButton button1 = new JButton("Boton 1");
        JButton button2 = new JButton("Boton 2");
        JButton button3 = new JButton("Boton 3");
        
        add(button1);
        add(button2);
        add(button3);
        
        Spring spring = Spring.constant(0, 10, 100); // minimo - preferido - maximo
        Spring staticSpring = Spring.constant(80);
        // Los argumentos corresponden a inicio del componenete - muelle - final de componente - otro componenete
        layout.putConstraint(SpringLayout.WEST, button1, spring, SpringLayout.WEST, this);
        // Partimos del oeste del boton para ir al oeste del panel
        layout.putConstraint(SpringLayout.WEST, button2, staticSpring, SpringLayout.EAST, button1);
        // Partimos del oeste del boton2 para ir al este del boton1
        layout.putConstraint(SpringLayout.WEST, button3, staticSpring, SpringLayout.EAST, button2);
        // Partimos del oeste del boton3 para ir al este del boton 3
        layout.putConstraint(SpringLayout.EAST, this, spring, SpringLayout.EAST, button3);
        // Partimos del este del panel para ir al este del boton3
    }
}