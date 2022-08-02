
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

public class Video99_28 {
    public static void main(String[] args) {
        myFrame25 window = new myFrame25();        
    }
}

class myFrame25 extends JFrame {
    public myFrame25() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Probando los Spinner");
                
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel21 myPanel = new Panel21();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel21 extends JPanel {
    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // {"Enero", "Febrero", "Marzo", "Abril"};
    JSpinner spinner = new JSpinner(new SpinnerNumberModel(5, 0, 10 ,1) {
        // Clase interna anonima
        public Object getNextValue() {
            return super.getPreviousValue();
        }

        public Object getPreviousValue() {
            return super.getNextValue();       
        }}); // SpinnerDateModel() - SpinnerListModel(array) - SpinnerNumberModel(inicio, minimo, maximo, paso)
    
    public Panel21() {
        Dimension dimension = new Dimension(200, 20);
        spinner.setPreferredSize(dimension);
        add(spinner);
    }

    /*
    // Creamos nuestro propio modelo para el spinner
    private class spinnerModel extends SpinnerNumberModel {
        public spinnerModel() {
            super(5, 0, 10 ,1);
        }

        public Object getNextValue() {
            return super.getPreviousValue();
        }

        public Object getPreviousValue() {
            return super.getNextValue();       
        }  
    }
    */
}
