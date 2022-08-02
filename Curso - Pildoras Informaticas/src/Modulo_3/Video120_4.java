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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.*;

public class Video120_4 {
    public static void main(String[] args) {
        MyFrame31 window = new MyFrame31();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame31 extends JFrame {
    public MyFrame31() {       
        setTitle("Probando layout Libre");
               
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel24 myPanel = new Panel24();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel24 extends JPanel {
    
    public Panel24() {
        setLayout(new layoutManager()); // Ponemos la disposicion que creamos
       //setLayout(null); // Desactivamos la disposicion por defecto
        
        JLabel name = new JLabel("Nombre:");
        //name.setBounds(20, 20, 100, 20); // Aqui jugamos con las cordenadas hasta 
        // ponerlo donde queramos
        JTextField userName = new JTextField();
        //userName.setBounds(120, 20, 100, 20);
        
        JLabel password = new JLabel("Contraseña:");
        //password.setBounds(20, 100, 100, 20);
        JTextField userPassword = new JTextField();
        //userPassword.setBounds(120, 100, 100, 20);
        
        JLabel email = new JLabel("Email:");
        JTextField userEmail = new JTextField();
        
        add(name);
        add(userName);
        add(password);
        add(userPassword);
        add(email);
        add(userEmail);

    }
}

class layoutManager implements LayoutManager {
    private int x, y;
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {        
        return null;       
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {      
        return null;
    }

    @Override
    public void layoutContainer(Container parent) { // Parent vendria siendo el contenedor donde se agrega
        // un elemento
        int componentWidth = parent.getWidth();
        x = componentWidth / 2; // Si el numero es decimal se trunca
        
        for(int i = 0; i < parent.getComponentCount(); i++) {
            Component component = parent.getComponent(i);
            component.setBounds(x - 100, y, 100, 20); // 100 = Ancho de los componentes
            
            x += 100;
            
            if((i + 1) % 2 == 0) { // Si agregamos dos elementos saltamos de "fila"
                x = componentWidth / 2;
                y += 40;
            }
        }
    }
    
}