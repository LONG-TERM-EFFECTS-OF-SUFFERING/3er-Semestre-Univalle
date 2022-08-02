
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Video95_26 {
    public static void main(String[] args) {
        myFrame23 window = new myFrame23();      
    }
}

class myFrame23 extends JFrame {
    public myFrame23() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Probando los ComboBox");
                
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel19 myPanel = new Panel19();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel19 extends JPanel {
    private JLabel text = new JLabel("En un lugar de la Mancha de cuyo nombre...");
    private JComboBox comboBox = new JComboBox();
    
    public Panel19() {
        setLayout(new BorderLayout());

        text.setFont(new Font("Serif", Font.PLAIN, 18));
        add(text, BorderLayout.CENTER);
        
        comboBox.setEditable(true); // Posibilita al usuario a ingresar sus propias opciones
        // Para anadir opciones al ComboBox se usa addItem
        comboBox.addItem("Serif");
        comboBox.addItem("SanSerif");
        comboBox.addItem("Monospaced");
        comboBox.addItem("Dialog");
        comboBox.addActionListener(new actionListener());
        add(comboBox, BorderLayout.NORTH);
    }

    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setFont(new Font((String) comboBox.getSelectedItem(), Font.PLAIN, 18)); // Hacemos casting al obtener el item seleccionado porque ese metodo retorna un "Object"
        }
    }

}
