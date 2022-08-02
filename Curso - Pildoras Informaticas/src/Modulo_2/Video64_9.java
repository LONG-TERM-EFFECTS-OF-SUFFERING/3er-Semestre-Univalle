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
import java.awt.event.*;


public class Video64_9 {
    public static void main(String[] args) {
        MyFrame7 window = new MyFrame7();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame7 extends JFrame {
    public MyFrame7() {
        setTitle("Mi primer evento");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        Panel6 myPanel = new Panel6();
        add(myPanel);   
    }
}
/* Primera implementación
class Panel5 extends JPanel implements ActionListener {
    JButton yellowButton = new JButton("yellow");
    JButton blueButton = new JButton("blue");
    JButton redButton = new JButton("red");
    
    public Panel5() {
        add(blueButton);
        add(yellowButton);
        add(redButton);
        
        yellowButton.addActionListener(this); // Objeto evento, a el se le hace la acción
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource(); // Guardamos al objeto de entrada en esta variable
        // para saber cual botón fue pulsado, y hacer algo diferente
        // Ahora los comparamos con las propias declaraciones anteriores
        if(buttonPressed == yellowButton) {
            setBackground(Color.yellow);
        } else if(buttonPressed == blueButton) {
            setBackground(Color.blue);
        } else {
            setBackground(Color.red);
        }       
    }
}
*/
class Panel6 extends JPanel {
    JButton yellowButton = new JButton("yellow");
    JButton blueButton = new JButton("blue");
    JButton redButton = new JButton("red");
    
    public Panel6() {
        add(blueButton);
        add(yellowButton);
        add(redButton);
        // Ahora hay un objeto por cada color
        backgroundColor yellow = new backgroundColor(Color.yellow);
        backgroundColor blue = new backgroundColor(Color.blue);
        backgroundColor red = new backgroundColor(Color.red);
        
        yellowButton.addActionListener(yellow); // Objeto evento, a el se le hace la acción
        blueButton.addActionListener(blue);
        redButton.addActionListener(red);
    }
    
    private class backgroundColor implements ActionListener { // Esta siendo una clase interna
        private Color color;
    
        public backgroundColor(Color color) {
            this.color = color;
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(color);
        }
}
}

