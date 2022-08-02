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
import javax.swing.*;


public class Video57_3 {
    public static void main(String[] args) {
        MyFrame window = new MyFrame();
        // También podemos configurar la ventana en el propio constructor
        window.setVisible(true); // Por defecto las ventanas aparecen invisibles, por eso necesitamos
        // especificar esto
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para que finalice la ejecución al cerrar
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        //setSize(500, 300);
        //setLocation(500, 300); // La posición de top-left de la ventana
        //setBounds(500, 300, 100, 100); // Este método junta los dos anteriores (x, y, alto, ancho)
        //setResizable(false); // Permitir o denegar que el usuario pueda redimensionar la ventana(por
        // defecto viene true)
        //setExtendedState(Frame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH corresponde al numero 6 (esa es la constante)
        setTitle("Mi ventana"); // Para darle un titulo a la ventana
        
        // Usamos Toolkit para hacer lo mas general, no importa en que computador se ejecute estará
        // centrado
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension screenSize = myScreen.getScreenSize();
        
        int height = screenSize.height;
        int width = screenSize.width;
        
        setSize(width / 2, height / 2);
        setLocation(width / 4, height / 4); // Como estamos centrando respecto al top-left entonces
        // debemos sacar mitad de alto y mitad de ancho (1 / 2 / 2 = 1 / 4)
        // Para agregarle un icono a la ventana 
        Image myIcon = myScreen.getImage("src/Modulo_2/icon.jpg");
        
        setIconImage(myIcon);
    }
}