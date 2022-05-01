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

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Triangulo;


public class VentanaTriangulo extends JFrame implements ActionListener{ // Con los implemnts se de debe implementar todos los metodos de ese implement
    // Los nombres deben ser indicativos (el codigo se documenta desde su escritura)
    private JLabel     lblBase;
    private JLabel     lblAltura;
    private JLabel     lblArea;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JTextField txtArea;
    private JButton    btnCalcular;
    private JButton    btnNuevo;
    private Container  contenedorPpal;
    
    public VentanaTriangulo(){
        iniciarComponentes();   
        setSize(350,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se termine la app cuando se cierre la ventana
        setTitle("Área Triangulo");
    }
    
    private void iniciarComponentes(){
        lblBase = new JLabel("Base : ");
        lblAltura = new JLabel("Altura : ");
        lblArea = new JLabel("Area : ");
        
        txtBase = new JTextField(15);
        txtBase.setHorizontalAlignment(JTextField.RIGHT);
        
        txtAltura  = new JTextField(15);
        txtAltura.setHorizontalAlignment(JTextField.RIGHT);
        
        txtArea  = new JTextField(15);
        
        
        txtArea.setEnabled(false);
        txtArea.setBackground(Color.YELLOW);
        txtArea.setDisabledTextColor(Color.red);
        txtArea.setHorizontalAlignment(JTextField.RIGHT);
        
      
        btnCalcular = new JButton("Calcular");
        btnNuevo = new JButton("Cancelar");
        
        
        contenedorPpal = getContentPane();
        
        contenedorPpal.setLayout(new GridLayout(4, 2));
        
        contenedorPpal.add(lblBase);
        contenedorPpal.add(txtBase);
        
        contenedorPpal.add(lblAltura);
        contenedorPpal.add(txtAltura);
        
        contenedorPpal.add(lblArea);
        contenedorPpal.add(txtArea);
        
        contenedorPpal.add(btnNuevo);
        contenedorPpal.add(btnCalcular);
        
        
        // Asignando al boton el Listener
        btnCalcular.addActionListener(this); // This porque el actionPerformed esta dentro de la misma clase
        btnNuevo.addActionListener(this);
                   
    }

    @Override // Indica que ese metodo se esta sobrescribiendo
    public void actionPerformed(ActionEvent ae) {
        // getSource devuelve el nombre del objeto al que le paso algo
        if(ae.getSource() == btnCalcular){
            
            // 1. Captura de  datos de las cajas de texto
            // parsefloat tranforma de string a float
            float base = Float.parseFloat(txtBase.getText());
            float altura = Float.parseFloat(txtAltura.getText());
            
            // 2. Instanciar un objeto triangulo
            Triangulo miTriangulo = new Triangulo(base, altura);
            // 3. Calcular el area
            miTriangulo.calcularArea();
            // 4. Desplegar el resultado
            // Si se le suma comilla o un string se convierte en string
            txtArea.setText(miTriangulo.getArea() + "");
            
        } else {
            JOptionPane.showMessageDialog(this,
                "Ocurrio un error en un control de la ventana");
        }   
    }    
}
