package Clase07_07.tercero.vista;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.*;
import Clase07_07.tercero.modelo.Funcionario;


public class Login extends JFrame{
    JLabel lblTitulo;
    JLabel lblFuncionario;
    JTextField txtFuncionario;
    JLabel lblTRM;
    JTextField txtTRM;
    JButton btnIngresar;
    JPanel panelDatos;
    
    public Login(){
        iniciarComponentes();
        
    }
    
     private void btnIngresarActionPerformed(){
       String nombre;
       nombre = txtFuncionario.getText();
       if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Funcionario funcionario = new Funcionario(nombre);
            try {
                double TRM = Double.parseDouble(txtTRM.getText());
                CotizadorGUI cotizador = new CotizadorGUI(funcionario,TRM);
                cotizador.setVisible(true);
                dispose();
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                         "Por favor ingrese un numero", 
                         "Error de Entrada de Dato",
                         JOptionPane.ERROR_MESSAGE);
            }
       }
       else{
           JOptionPane.showMessageDialog(null,"Por favor ingrese el nombre del funcionairo", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtFuncionario.requestFocusInWindow();                 
       }
     }
    
    private void iniciarComponentes(){
        
        panelDatos = new JPanel();
        lblFuncionario = new JLabel();
        txtFuncionario = new JTextField();
        lblTRM = new JLabel();
        txtTRM = new JTextField();
        btnIngresar = new JButton();
        lblTitulo = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Datos", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 13), new Color(0, 102, 204))); 
       
        lblFuncionario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFuncionario.setText("Funcionario");

        lblTRM.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTRM.setText("TRM");        
        txtTRM.setHorizontalAlignment(JTextField.RIGHT);
        
        
        lblTitulo.setFont(new Font("Tahoma", 1, 24));
        lblTitulo.setForeground(new Color(0, 102, 204));
        lblTitulo.setText("Login Cotizador de Traducciones");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener((ActionEvent e) -> {
            btnIngresarActionPerformed();
        });

        GroupLayout panelDatosLayout = new GroupLayout(panelDatos);
        
        panelDatos.setLayout(panelDatosLayout);
        
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup()
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup()
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFuncionario))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblTRM)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup()
                    .addComponent(txtFuncionario)
                    .addComponent(txtTRM))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addContainerGap())
        );
        
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup()
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup()
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup()
                            .addComponent(txtFuncionario)
                            .addComponent(lblFuncionario))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup()
                            .addComponent(lblTRM)
                            .addComponent(txtTRM))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnIngresar))
                .addContainerGap())
        );

        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup()
                    .addComponent(lblTitulo)
                    .addComponent(panelDatos))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(panelDatos)
                .addContainerGap(30, Short.MAX_VALUE))
        );
          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cotizador de Traductores");
        setSize(450, 230);
        setResizable(false);
        setLocationRelativeTo(this);
    }       
}
