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

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Video101_30 {
    public static void main(String[] args) {
        MyFrame27 window = new MyFrame27();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame27 extends JFrame {
    public MyFrame27() {
        setTitle("Editor de texto");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel22 myPanel = new Panel22();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel22 extends JPanel {   
    private JTextPane textPane = new JTextPane();
    private JMenu font = new JMenu("Fuente"), style = new JMenu("Estilo"),size = new JMenu("Tamaño");
    
    public Panel22() {
        setLayout(new BorderLayout());
        
        JPanel menu = new JPanel();
        
        JMenuBar menuBar = new JMenuBar();
        
        // ------------------------------------------ //
        addMenuItem("Arial", font);
        addMenuItem("Courier", font);
        addMenuItem("Verdana", font);
        // ------------------------------------------ //
        addMenuItem("Negrita", style);
        addMenuItem("Cursiva", style);
        // ------------------------------------------ //
        addMenuItem("12", size);
        addMenuItem("16", size);
        addMenuItem("20", size);
        addMenuItem("24", size);
                  
        menuBar.add(font);
        menuBar.add(style);
        menuBar.add(size);
               
        add(menuBar, BorderLayout.NORTH);
        add(textPane, BorderLayout.CENTER);
    }
    
    private void addMenuItem(String name, JMenu menu) {
        JMenuItem menuItem = new JMenuItem(name);
        
        if(menu == font) {
            menuItem.addActionListener(new actionListener("font", name));
        } else if(menu == style) {
            int styleNumber = 0;
            if(name.equals("Negrita")) {
                styleNumber = Font.BOLD;                               
            } else { // Caso cursiva
                styleNumber = Font.ITALIC;
            }
            menuItem.addActionListener(new actionListener("style", styleNumber));
        } else { // Caso size
            menuItem.addActionListener(new actionListener("size", name));
        }       
        menu.add(menuItem);      
    }
    
    private class actionListener implements ActionListener {
        private String propertyToChange;
        private Object propertyValue;
        
        public actionListener(String propertyToChange, Object propertyValue) { // Como le entran atributos
            // de diferentes tipos, lo declaramos como Object (para hacerlo general)
            this.propertyToChange = propertyToChange;
            this.propertyValue = propertyValue;

        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Font actualFont = textPane.getFont();      
            int fontStyle = actualFont.getStyle(); // Captura el ultimo estilo aplicado
            int fontSize = actualFont.getSize();
            String fontName = actualFont.getFontName();
        
            switch (propertyToChange) {
                case "font" -> fontName = ((String) propertyValue).toLowerCase();
                case "style" -> {
                    if(fontStyle == 1 ||fontStyle == 2) {
                        fontStyle = 3;
                    } else {
                        fontStyle = (int) propertyValue;  
                    }                
                }
                default -> // Caso del size    
                    fontSize = Integer.parseInt((String) propertyValue);
            }
            textPane.setFont(new Font(fontName, fontStyle, fontSize));
        }     
    }
    // En el estado actual no estan programadas las acciones de quitar propiedades, pero se puede
    // hacer facilmente evaluando en el actionListener si la propiedad ya esta activada, en tal caso
    // se quita
}