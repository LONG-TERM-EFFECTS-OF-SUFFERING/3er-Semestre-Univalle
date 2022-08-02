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
import java.io.*;
import javax.imageio.ImageIO;


public class Video63_8 {
    public static void main(String[] args) {
        MyFrame6 window = new MyFrame6();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame6 extends JFrame {
    public MyFrame6() {
        setTitle("Imagenes");
                
        setBounds(1920 / 2 - 150, 1080 / 2 - 100, 300, 200);
        
        Panel5 myPanel = new Panel5();
        myPanel.setForeground(Color.GREEN); // Para de todo lo que pongamos en el panel
        add(myPanel);
        setVisible(true);
    }
}

class Panel5 extends JPanel {
    private Image image;
    
    public Panel5() {
        // Aprovechando que declaramos la imagen como atributo podemos hacer esto
        File myImage = new File("src/Modulo_2/circulo_rrojo.png");
        try {
        image = ImageIO.read(myImage); // Este método arroja una excepción, entonces tenemos que atraparla
        } catch(IOException e) {
            System.out.println("Ha ocurrido un error !");
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        if(image != null) { // Tambien podemos capturar la excepcion agregandole al metodo un
            // throws NullPointerException
            int imageHeight = image.getHeight(this); // El observador es el panel
            int imageWidth = image.getWidth(this);
        
            g.drawImage(image, 0, 0, null); // El bucle la vuelve a dibujar en esa posición
        
            for(int i = 0; i < 300; i += imageWidth){ // Este va a recorrer el eje "x"
                for(int j = 0; j < 200; j += imageHeight){ // Este va a recorrer el eje "y"
                    g.copyArea(0, 0, imageWidth, imageHeight, i, j);
                }    
            }            
        } else {
            g.drawString("No se ha encontrado la imagen !", 10, 10);
        }
        g.drawLine(0, 0, 0, 200);
    }
}