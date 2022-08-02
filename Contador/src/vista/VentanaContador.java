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

package vista;

import modelo.Contador;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class VentanaContador extends JFrame implements ActionListener, MouseListener { 
    private Contador miContador = new Contador();
    private JLabel lblTitulo;
    private JButton btnBoton;
    private JButton btnBotonEstablecer;
    private JTextField txtCuenta;
    private Container contenedorPpal;

    
    public VentanaContador() {
        iniciarComponentes();   
        setSize(350, 150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Contador");
    }
    
    private void iniciarComponentes() {
        lblTitulo = new JLabel("Digite donde quiere que comience la cuenta (por defecto es cero)");
        
        btnBotonEstablecer = new JButton("Establecer");
        btnBoton = new JButton("Boton");
        btnBoton.setVisible(false);

        txtCuenta  = new JTextField(15);
        

        txtCuenta.setBackground(Color.YELLOW);
        txtCuenta.setDisabledTextColor(Color.red);
        txtCuenta.setHorizontalAlignment(JTextField.RIGHT);
        txtCuenta.setText(miContador.getCuenta() + "");
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(new GridLayout(4, 1));
        contenedorPpal.add(lblTitulo);
        contenedorPpal.add(txtCuenta);
        contenedorPpal.add(btnBotonEstablecer);  
        contenedorPpal.add(btnBoton);
        
        btnBotonEstablecer.addActionListener(this);
        btnBoton.addMouseListener(this);
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnBotonEstablecer) {
            if("".equals(txtCuenta.getText())){ // Si el usuario no ingreso nada en el campo de texto
                miContador.setCuenta(0);
            } else {
                try {
                    int inicio = Integer.parseInt(txtCuenta.getText());
                    miContador.setCuenta(inicio);
                }
                catch(Exception e) { // Si quiero vol ver a darle la oportunidad de ingresar otro se tendria que hacer un while
                    JOptionPane.showMessageDialog(this, "No ha ingresado un numero, por defecto la cuenta empezara en 0");
                    miContador.setCuenta(0);
                }
            }
            lblTitulo.setText("Estado cuenta"); // Cambiamos el titulo
            txtCuenta.setText(miContador.getCuenta() + ""); // Actualizamos el texto del contador y lo convertimos a string
            txtCuenta.setEnabled(false); // Lo inhabilitamos porque ya se ingreso el numero
            
            btnBotonEstablecer.setVisible(false); // Ocultamos el botón
            btnBoton.setVisible(true); // Hacemos visible el otro botón
        } else {
            JOptionPane.showMessageDialog(this,
                "Ocurrió un error en un control de la ventana");
        }
    }
    
    // Con esto gestionamos los eventos del mouse
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == btnBoton) {
            if(me.getButton() == MouseEvent.BUTTON3) {
                // Clic derecho
                miContador.disminuirCuenta();
                txtCuenta.setText(miContador.getCuenta() + "");
            } else if(me.getButton() == MouseEvent.BUTTON1){
                // Clic izquierdo
                miContador.aumentarCuenta();
                txtCuenta.setText(miContador.getCuenta() + "");
            } else if(me.getButton() == MouseEvent.BUTTON2) {
                // Rueda
                int opcion = JOptionPane.showConfirmDialog(null, "¿ Desea reiniciar a cero ?", "Reinicio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch(opcion) {
                        case JOptionPane.YES_OPTION:
                            miContador.setCuenta(0);
                            txtCuenta.setText(miContador.getCuenta() + "");
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        default:
                            break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}