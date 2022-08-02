/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoresdistribucion;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

/**
 *
 * @author Yovany
 */
public class Empleado extends JFrame{
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblEdad;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtEdad;
    private Container contenedor;
    
    public Empleado(){
        
        iniciarComponentes();
        setTitle("Gestión de Empleado");
        setSize(600,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
    }
    
    private void iniciarComponentes(){
        lblNombres = new JLabel("Nombres : ");
        lblApellidos = new JLabel("Apelldios : ");
        lblEdad = new JLabel("Edad : ");
        txtNombres = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtEdad = new JTextField(10);
        
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        contenedor.add(lblNombres);
        contenedor.add(txtNombres);
        contenedor.add(lblApellidos);
        contenedor.add(txtApellidos);
        contenedor.add(lblEdad);
        contenedor.add(txtEdad);
    }
      
}