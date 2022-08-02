package Modulo_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Video121_5 {
    public static void main(String[] args) {		
        MyFrame32 window = new MyFrame32();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
    }
}

class MyFrame32  extends JFrame{		
    public MyFrame32 () {
        setTitle("Probando layout Libre");
               
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel25 myPanel = new Panel25();       
        add(myPanel);
        setVisible(true);			
    }		
}

class Panel25  extends JPanel {
    private JButton button1 = new JButton("Boton1");;
    private JButton button2 = new JButton("Boton2");;
    private JButton button3 = new JButton("Boton3");;
    private JButton button4 = new JButton("Boton4");;
        
	public Panel25() {					
							
            button1.addActionListener(new actionListener());
            button2.addActionListener(new actionListener());
            button3.addActionListener(new actionListener());
            button4.addActionListener(new actionListener());
				
            add(button1);
            add(button2);
            add(button3);
            add(button4);
	}
			
    private class actionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            
            if (pressedButton== button1) {
		JOptionPane.showMessageDialog(Panel25.this, "Haz presionado el boton 1", "Ventana emergente", 3);
                // Podemos agregarle un titulo a la ventana introduciendolo como tercer argumento, al igual que
                // un icono agregandole un cuarto argumento: por defecto es el de notificacion (1), pero tambien 
                // hay: (0) error, (2) advertencia y (3) interrogacion

            } else if(pressedButton == button2) {
		JOptionPane.showInputDialog(Panel25.this, "Introduce un dato", "Introduccion datos", 2);
            } else if(pressedButton == button3) {
		JOptionPane.showConfirmDialog(Panel25.this, "Elige una opcion:", "Seleccion de opcion", 2);
                // El tercer argumento es para cambiar el set de opciones que muestra: (0) Yes - No, (1) Yes - No - Cancel
                // y por ultimo (2) Ok - Cancel
            } else { // Caso button4
		JOptionPane.showOptionDialog(Panel25.this, "Elige una opcion:", "Seleccion de opcion", 1, 1, null, null, null);
            }
        }	
    }
	
}