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


public class Video79_16 {
    public static void main(String[] args) {
        MyFrame13 window = new MyFrame13();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame13 extends JFrame {
    public MyFrame13() {
        setTitle("Fuentes de eventos multiples");
        setVisible(true); 
        
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 600, 200);
        
        Panel8 myPanel = new Panel8();       
        add(myPanel);   
    }
}

class Panel8 extends JPanel {
    
    public Panel8() {
        MyAction yellow = new MyAction("Amarillo", new ImageIcon("src/Modulo_2/circulo_amarillo.png"), Color.YELLOW);
        MyAction blue = new MyAction("Azul", new ImageIcon("src/Modulo_2/circulo_azul.png"), Color.BLUE);
        MyAction red = new MyAction("Rojo", new ImageIcon("src/Modulo_2/circulo_rojo.png"), Color.RED);
        
        add(new JButton(yellow)); // Este es uno de los varios constructores que tiene esta clase
        add(new JButton(blue));
        add(new JButton(red));
        
        /*
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        
        add(yellowButton);
        add(blueButton);
        add(yellowButton);
        */
        // 1. Crear mapa de entrada
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); // Accedemos a algo que esta dentro de el panel
        // 2. Crear combinación de teclas y 3. Asignar combinación de teclas a objeto
        inputMap.put(KeyStroke.getKeyStroke("ctrl Y"),"Yellow shortcut");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"),"Blue shortcut");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"),"Red shortcut");
        
        ActionMap actionMap = getActionMap();
        // 4. Asignar objetos a acción
        actionMap.put("Yellow shortcut", yellow);
        actionMap.put("Blue shortcut", blue);
        actionMap.put("Red shortcut", red);
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

