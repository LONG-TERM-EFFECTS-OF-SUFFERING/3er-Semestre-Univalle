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

import javax.swing.*;

public class Video115_2 {
    public static void main(String[] args) {
        MyFrame29 window = new MyFrame29();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame29 extends JFrame {
    public MyFrame29() {
        setTitle("Probando la disposicion Box");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        JLabel name = new JLabel("Nombre:");
        
        JTextField userName = new JTextField(10);
        userName.setMaximumSize(userName.getPreferredSize());
        
        Box box1 = Box.createHorizontalBox();
        
        box1.add(name);
        box1.add(Box.createHorizontalStrut(10)); // Espacio horizontal fijo
        box1.add(userName);
        
        JLabel password = new JLabel("Contraseña:");
        
        JTextField userPassword = new JTextField(10);
        userPassword.setMaximumSize(userName.getPreferredSize());
        
        Box box2 = Box.createHorizontalBox();
        
        box2.add(password);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(userPassword);
        
        Box box3 = Box.createHorizontalBox();
        
        JButton button1 = new JButton("Ok");
        JButton button2 = new JButton("Cancelar");
        
        box3.add(button1);
        box3.add(Box.createGlue()); // Espacio horizontal variable
        box3.add(button2);
        
        Box box4 = Box.createVerticalBox();
        box4.add(box1);
        box4.add(box2);
        box4.add(box3);
        
        add(box4);
        setVisible(true);
    }
}

