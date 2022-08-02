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

import java.awt.event.*;
import javax.swing.*;


public class Video80_17 {
    public static void main(String[] args) {
        MyFrame14 window = new MyFrame14();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

class MyFrame14 extends JFrame {
    public MyFrame14() {
        setTitle("Multiple oyentes");

        setBounds(1920 / 2 - 150, 1080 / 2 - 75, 300, 150);

        Panel9 panel = new Panel9();
        add(panel);
    }
    
}

class Panel9 extends JPanel {
    JButton closeButton;
    
    public Panel9() {
        JButton openButton = new JButton("Nuevo");
        closeButton = new JButton("Cerrar todo");

        add(openButton);
        add(closeButton);

        openButton.addActionListener(new myActionListener());
    }

    private class myActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            popUpWindow window = new popUpWindow(closeButton); // Le damos el botón como parámetro para
            // lograr un "enlace"
        }
    }
}

class popUpWindow extends JFrame {
    private static int counter = 0; // Vamos a llevar la cuenta de cuantas ventanas se crean
    
    public popUpWindow(JButton botonCerrar) {
        counter++;
    
        setTitle("Ventanta" + counter);

        setBounds(40 * counter, 40 * counter, 300, 150); // Con los primeros dos argumentos logramos
        // el efecto cascada

        setVisible(true);

        botonCerrar.addActionListener(new CloseAll());
    }

    private class CloseAll implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
