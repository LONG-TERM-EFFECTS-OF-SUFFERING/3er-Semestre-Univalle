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

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer; // Como hay varias clases Timer le especificamos de cual paquete la queremos


public class Video52_1 {
    public static void main(String[] args) {
        getTime actionListener = new getTime(); // Usamos el constructor por defecto
        // También podemos instanciarlo asi ActionListener actionListener = new getTime();
        Timer myTimer = new Timer(5000, actionListener); // Como segundo argumento recibe un objeto
        myTimer.start();
        
        JOptionPane.showMessageDialog(null, "Pulsa OK para detener el programa");
        
        System.exit(0); // Para que al darle aceptar el programa finalice su ejecución
    }
}

class getTime implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date(); // Los datos dentro del objeto se inicializan cuando se crea
        System.out.println("Hora:" + now);
        Toolkit.getDefaultToolkit().beep(); // Para que haga un sonido
        // Toolkit es una serie de herramientas para comunicarse con el PC del usuario
    }
}