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
import java.util.Date;


public class Video53_2 {
    public static void main(String[] args) {
        /*
        Clock myClock = new Clock(3000, true); // Solo estamos usando la instancia una vez, entonces
        // nuestro programa es candidato, para usar clases internas locales 
        myClock.running();
        */

        Clock myClock = new Clock();
        myClock.running(3000, true);
        
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener el programa");
        System.exit(0);
    }
}

class Clock {
    /* Ahora que el método va a recibir esta información directamente podemos prescindir de estos atributos
    private int     interval;
    private boolean sound;
    
    
    public Clock(int interval, boolean sound) {
        this.interval = interval;
        this.sound = sound;
    }
    
    public void running() {
        getTime2 actionListener = new getTime2();
        Timer myTimer = new Timer(interval, actionListener);
        myTimer.start();
    }
    
    private class getTime2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Date now = new Date(); // Los datos dentro del objeto se inicializan cuando se crea
            System.out.println("Hora:" + now);
            if(sound) Toolkit.getDefaultToolkit().beep(); // Como es una clase interna podemos acceder
            // directamente al atributo sound
        }
    }
    */
    
    public void running(int interval, final boolean sound) {
        class getTime2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date(); // Los datos dentro del objeto se inicializan cuando se crea
                System.out.println("Hora:" + now);
                if(sound) Toolkit.getDefaultToolkit().beep(); // Como es una clase interna podemos acceder
                // directamente al atributo sound
            }
        }
        getTime2 actionListener = new getTime2();
        Timer myTimer = new Timer(interval, actionListener);
        myTimer.start();
    }
}