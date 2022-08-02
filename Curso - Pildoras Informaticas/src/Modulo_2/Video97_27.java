
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
import javax.swing.event.*;
import java.awt.*;

public class Video97_27 {
    public static void main(String[] args) {
        myFrame24 window = new myFrame24();
        
    }
}

class myFrame24 extends JFrame {
    public myFrame24() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Probando los Slider");
                
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel20 myPanel = new Panel20();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel20 extends JPanel {
    private JLabel text = new JLabel("En un lugar de la Mancha cuyo nombre...");
    JSlider slider = new JSlider(8 , 50, 12); // Por defecto se cra con un valor minimo de 0 y maximo de 100, con el valor inicial en 50 (centro)
    
    public Panel20() {
        setLayout(new BorderLayout());
        add(text, BorderLayout.CENTER);
        
        //slider.setOrientation(SwingConstants.VERTICAL); // Puede estar vertical y horizontal
        slider.setMajorTickSpacing(20); // Marcas grandes
        slider.setMinorTickSpacing(5); // Marcas pequeñas
        slider.setFont(new Font("Serif", Font.ITALIC, 12));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true); // Deja el valor en la marca mas cercana
        slider.addChangeListener(new changeListener());
        add(slider, BorderLayout.NORTH);
    }

    private class changeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            //System.out.println("Valor slider: " + slider.getValue());
            text.setFont(new Font("Serif", Font.PLAIN, slider.getValue()));
        }
    }

}
