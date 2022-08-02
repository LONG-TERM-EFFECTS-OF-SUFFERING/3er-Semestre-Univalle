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
import java.awt.*;
import java.awt.event.*;
import static javax.swing.Action.NAME;


public class Video111_1 {
    public static void main(String[] args) {
        MyFrame28 window = new MyFrame28();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame28 extends JFrame {
    public MyFrame28() {
        setTitle("Probando JToolBar");
         
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        MyAction yellow = new MyAction("Amarillo", new ImageIcon("src/Modulo_2/circulo_amarillo.png"), Color.YELLOW);
        MyAction blue = new MyAction("Azul", new ImageIcon("src/Modulo_2/circulo_azul.png"), Color.BLUE);
        MyAction red = new MyAction("Rojo", new ImageIcon("src/Modulo_2/circulo_rojo.png"), Color.RED);
        Action exit = new AbstractAction("Salir", new ImageIcon("src/Modulo_2/exit.png")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cerramos la aplicacion
            }
        };
        
        JMenu menu = new JMenu("Color");
        menu.add(yellow);
        menu.add(blue);
        menu.add(red);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        
        setJMenuBar(menuBar);
            
        JToolBar toolBar = new JToolBar();
        toolBar.add(yellow);
        toolBar.add(blue);
        toolBar.add(red);
        toolBar.addSeparator();
        toolBar.add(exit);
        add(toolBar, BorderLayout.NORTH);
        
        setVisible(true);
    }
    
    private class MyAction extends AbstractAction {
        public MyAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Poner el panel de color" + name);
        
            putValue("Background_Color", color); // Vamos a usar una propiedad que creamos
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("Background_Color");
        
            setBackground(color);
            
            System.out.println("Nombre: " + getValue(NAME));
        }     
    }    
}

