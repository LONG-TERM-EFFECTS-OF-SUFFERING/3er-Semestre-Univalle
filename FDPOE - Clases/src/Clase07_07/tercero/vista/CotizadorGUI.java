package Clase07_07.tercero.vista;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import javax.swing.border.*;

import Clase07_07.tercero.modelo.Archivo;
import Clase07_07.tercero.modelo.Funcionario;
import Clase07_07.tercero.logica.Cotizador;
import Clase07_07.tercero.modelo.Cliente;
import Clase07_07.tercero.modelo.Cotizacion;


public class CotizadorGUI extends JFrame {
   
    private JButton btnAgregar;
    private JButton btnNueva;
    private JButton btnSalir;
    private JButton btnPrimero;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JComboBox<String> cbxDocumento;
    private JComboBox<String> cbxTiempo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jpControles;
    private JScrollPane jScrollPane1;
    private JList<String> jlArchivos;
    private JLabel lblCliente;
    private JLabel lblEmail;
    private JLabel lblFuncionario;
    private JLabel lblFuncionario1;
    private JLabel lblFuncionario4;
    private JLabel lblFuncionario5;
    private JLabel lblTiempo;
    private JLabel lblTipo;
    private JTextField txtCantidadArchivos;
    private JTextField txtCantidadPalabras;
    private JTextField txtCliente;
    private JTextField txtCotizacionDolares;
    private JTextField txtCotizacionPesos;
    private JTextField txtEmail;
    private JTextField txtFuncionario;
    private JTextField txtFuncionario2;
    private JTextField txtTRM;
    private JTextField txtTRM2;
       
    ArrayList<Archivo> listaArchivos = new ArrayList();
    DefaultListModel modelo = new DefaultListModel();
    Cotizacion cotizacion;
    Cotizador cotizador;
    DecimalFormat formato ;

    private String tiempo;
    private String tipo;
    private int activa = 0;
    private int activaAnterior = 0;
    
    /**
     * Creates new form Cotizador
     * @param funcionario
     * @param TRM
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public CotizadorGUI(Funcionario funcionario, double TRM) {
        iniciarComponentes();
                
        cotizador = null;
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream("src/archivos/cotizador.data"));
            cotizador = (Cotizador) ois.readObject();
            cotizador.setFuncionario(funcionario);
            cotizador.setTRM(TRM);
        } catch (FileNotFoundException ex) {            
            System.out.println("Archivo no existe : " + ex.getMessage());
        } catch (IOException ex) {            
            System.out.println("Error leyendo 1 : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {            
            System.out.println("Error leyendo 2 : " + ex.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {                    
                    System.out.println("Error : " + ex.getMessage());
                }
            }
        }
        
        if (cotizador == null) {
            //No encontró el archivo y genera un nuevo cotizador
            cotizador = new Cotizador(funcionario, TRM);                
        }
        
        activa = 1;
        
       // activarNavegacion(jpControles,false, activa);
        
        if(cotizador.getCantidadCotizaciones() == 0){               
            activa = 0;
            activarNavegacion(jpControles,false, activa);                
        } else{
            if(cotizador.getCantidadCotizaciones() == 1){                
                activarNavegacion(jpControles,false, activa);
            } else{
                activarNavegacion(jpControles,true, activa);               
            }           
        }
        
        actualizarVistaCotizacion(activa);     

        jlArchivos.setModel(modelo);
        
        formato = new DecimalFormat("###,###,##0.00");


        setTitle("Cotizador de Traducciones");
        setLocationRelativeTo(null);
    }
    
    public void activarNavegacion(JPanel panel, boolean estado, int activo) 
    { 
        Component[] componentes = panel.getComponents(); 
        
        for (Component componente : componentes) {
            if (componente instanceof JButton) {
                ((JButton) componente).setEnabled(estado);
            }
        } 
        
        int total = cotizador.getCantidadCotizaciones();
        if(activo == 1){
            btnPrimero.setEnabled(false);
            btnAnterior.setEnabled(false);
        }
        
        if (activo == total && total >= 1 ){
            btnUltimo.setEnabled(false);
            btnSiguiente.setEnabled(false);
        }
        
        jpControles.setBorder(BorderFactory.createTitledBorder(null, 
                "Controles de Navegación - Registro "+ activo + " de " + total, 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), 
                new Color(0, 153, 204))); 
    } 
    
    private void actualizarVistaCotizacion(int activa){

        formato = new DecimalFormat("###,###,##0.00");
        if(activa>0){

            Cotizacion cotizacion = cotizador.getCotizacion(activa);
            cotizacion.toString();
            modelo.removeAllElements();
            txtFuncionario.setText(cotizacion.getFuncionario().getNombre());
            txtTRM.setText(String.valueOf(cotizacion.getTRM()));
            txtCliente.setText(cotizacion.getCliente().getNombre());
            txtEmail.setText(cotizacion.getCliente().getEmail());
            cbxDocumento.setSelectedItem(cotizacion.getTipo());
            cbxTiempo.setSelectedItem(cotizacion.getTiempo());
            txtCantidadPalabras.setText(String.valueOf(
                    formato.format(cotizacion.getTotalPalabras())));
            txtCantidadArchivos.setText(String.valueOf(
                    formato.format(cotizacion.getTotalArchivos())));
            
            txtCotizacionPesos.setText(String.valueOf(
                    formato.format(cotizacion.getCotizacionPesos())));
            
            
            txtCotizacionDolares.setText(String.valueOf(
                    formato.format(cotizacion.getCotizacionDolares())));
            
            ArrayList<Archivo> listaArchivos = cotizacion.getListaArchivos();
            for(Archivo archivo : listaArchivos){
                modelo.addElement(archivo.getArchivo().getName() + "con " 
                        + archivo.getCantidadPalabras() + " PALABRAS)");
            }
            
        } else{
            txtFuncionario.setText(cotizador.getFuncionario().getNombre());
            txtTRM.setText(String.valueOf(cotizador.getTRM()));
        }
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = 
                new FileNameExtensionFilter("Archivo de Texto", "txt", "text");
        fileChooser.setFileFilter(filtro);
        fileChooser.setMultiSelectionEnabled(true);
        
        int seleccion= fileChooser.showOpenDialog(this);
        if(seleccion != JFileChooser.CANCEL_OPTION){
            File[] archivos = fileChooser.getSelectedFiles();
            
            cotizacion.agregarArchivos(archivos, modelo);
            btnNueva.setEnabled(true);
            
            actualizarValoresCotizacion();
        }
    }                                          

    private void cbxDocumentoItemStateChanged(ItemEvent evt) {                                              
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tipo = cbxDocumento.getSelectedItem().toString();
        
            cotizacion.setTipo(tipo);
            cotizacion.actualizarCotización();
            actualizarValoresCotizacion();
        }
    }                                             

    private void cbxTiempoItemStateChanged(ItemEvent evt) {                                           
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tiempo = cbxTiempo.getSelectedItem().toString();
        
            cotizacion.setTiempo(tiempo);
            cotizacion.actualizarCotización();
            actualizarValoresCotizacion();
        }
    }                                          

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if(btnNueva.getText().equalsIgnoreCase("Nueva")){
            //Inicia una nueva cotización
            
            int numero = cotizador.getConsecutivo() + 1;
            activaAnterior = activa;
            tiempo = cbxTiempo.getSelectedItem().toString();
            tipo = cbxDocumento.getSelectedItem().toString();
            txtFuncionario.setText(cotizador.getFuncionario().getNombre());
            txtTRM.setText(String.valueOf(cotizador.getTRM()));
            cotizacion = new Cotizacion(numero, cotizador.getFuncionario(), 
                    tipo, tiempo, cotizador.getTRM());
            
            activarControles(true);
            
            btnNueva.setText("Grabar");
            btnSalir.setText("Cancelar");
            btnNueva.setEnabled(false);
            
            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                    "Cotización No. " + numero, 
                    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                    javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                    new java.awt.Font("Tahoma", 1, 12), 
                    new java.awt.Color(0, 153, 204))); // NOI18N
            
            reiniciarControles();
            activarNavegacion(jpControles, false, numero);
            txtCliente.requestFocusInWindow();
            
        }else{
            /*Graba cotizacion*/
            String nombre = txtCliente.getText();
            String email = txtEmail.getText();
            
            if( (!nombre.trim().isEmpty() || nombre.trim().length() > 0) &&
                    (!email.trim().isEmpty() || email.trim().length() > 0) ){
                
                tiempo = cbxTiempo.getSelectedItem().toString();
                tipo = cbxDocumento.getSelectedItem().toString();
                
                Cliente cliente = new Cliente(nombre,email);
                
                cotizacion.setCliente(cliente);
                cotizacion.setTiempo(tiempo);
                cotizacion.setTipo(tipo);
                
                cotizador.setConsecutivo(cotizacion.getNumero());
                
                try {
                    cotizador.agregarCotizacion(cotizacion);
                } catch (IOException ex) {
                    Logger.getLogger(CotizadorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                activarControles(false);
                btnNueva.setText("Nueva");
                btnSalir.setText("Salir");
                
                activa = cotizacion.getNumero();

                activarNavegacion(jpControles,true, activa );
                actualizarVistaCotizacion(activa);

                btnNueva.requestFocusInWindow();                                                
                
            } else {
                JOptionPane.showMessageDialog(null, "Nombre o Email vacio", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            }       
        }        
    }  
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if(btnSalir.getText().equalsIgnoreCase("Salir")){
            //Sale de la aplicación y graba el objeto cotizador en el
            //archivo cotizador.data
            
            ObjectOutputStream oos = null;
            
            try {
                oos = new ObjectOutputStream(new FileOutputStream("src/archivos/cotizador.data"));
                oos.writeObject(cotizador);
            } catch (FileNotFoundException ex) {
                System.out.print("Error grabando " + ex.getMessage());
            } catch (IOException ex) {
                System.out.print("Error grabando " + ex.getMessage());
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException ex) {
                        System.out.print("Error " + ex.getMessage());
                    }
                }
            }
            
            dispose();
        } else {
            //Cancela el proceso de cotización
            activa = activaAnterior;
            activarControles(false);
            modelo.removeAllElements();
            reiniciarControles();
            
            actualizarVistaCotizacion(activa);
            activarNavegacion(jpControles,true, activa );
            btnSalir.setText("Salir");
            btnNueva.setText("Nueva");
            btnNueva.setEnabled(true);            
        }
    }  

    private void actualizarValoresCotizacion(){
        //Actualiza la vista con los datos recalculados
        txtCantidadArchivos.setText(String.valueOf(
                    cotizacion.getTotalArchivos()));
        txtCantidadPalabras.setText(String.valueOf(
                    cotizacion.getTotalPalabras()));
        txtCotizacionDolares.setText(String.valueOf(
                    formato.format(cotizacion.getCotizacionDolares())));
        txtCotizacionPesos.setText(String.valueOf(
                    formato.format(cotizacion.getCotizacionPesos())));
    }
    
    private void reiniciarControles(){
        modelo.removeAllElements();
        txtCliente.setText("");
        txtEmail.setText("");
        txtCantidadArchivos.setText("");
        txtCantidadPalabras.setText("");
        txtCotizacionDolares.setText("");
        txtCotizacionPesos.setText("");          
    }
    
                                          

    private void activarControles(boolean estado){
        txtCliente.setEnabled(estado);
        txtEmail.setEnabled(estado);
        cbxDocumento.setEnabled(estado);
        cbxTiempo.setEnabled(estado);
        btnAgregar.setEnabled(estado);
        jlArchivos.setEnabled(estado);
    }
      
    public void iniciarComponentes(){
        jPanel3 = new JPanel();
        jpControles = new JPanel();
        lblFuncionario4 = new JLabel();
        txtFuncionario2 = new JTextField();
        lblFuncionario5 = new JLabel();
        txtTRM2 = new JTextField();
        jPanel1 = new JPanel();
        lblFuncionario = new JLabel();
        txtFuncionario = new JTextField();
        lblFuncionario1 = new JLabel();
        txtTRM = new JTextField();
        jPanel2 = new JPanel();
        lblTipo = new JLabel();
        lblTiempo = new JLabel();
        cbxDocumento = new JComboBox<>();
        cbxTiempo = new JComboBox<>();
        lblCliente = new JLabel();
        lblEmail = new JLabel();
        txtCliente = new JTextField();
        txtEmail = new JTextField();
        btnNueva = new JButton();
        btnSalir = new JButton();
        btnPrimero = new JButton();
        btnAnterior = new JButton();
        btnSiguiente = new JButton();
        btnUltimo = new JButton();
        jPanel4 = new JPanel();
        txtCantidadArchivos = new JTextField();
        txtCantidadPalabras = new JTextField();
        txtCotizacionPesos = new JTextField();
        txtCotizacionDolares = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPanel5 = new JPanel();
        btnAgregar = new JButton();
        jScrollPane1 = new JScrollPane();
        jlArchivos = new JList<>();

        jPanel3.setBorder(BorderFactory.createTitledBorder(null, 
                "Traducciones Perfectas", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), 
                new Color(0, 153, 204))); 

        lblFuncionario4.setFont(new Font("Tahoma", 1, 11)); 
        lblFuncionario4.setText("Funcionario ");

        txtFuncionario2.setEditable(false);

        lblFuncionario5.setFont(new Font("Tahoma", 1, 11)); 
        lblFuncionario5.setText("TRM del Día");

        txtTRM2.setEditable(false);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblFuncionario4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFuncionario2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(lblFuncionario5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTRM2)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(txtFuncionario2)
                    .addComponent(lblFuncionario4)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTRM2)
                        .addComponent(lblFuncionario5)))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, 
                "Traducciones Perfectas", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 12), 
                new Color(0, 153, 204))); // NOI18N

        lblFuncionario.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        lblFuncionario.setText("Funcionario ");

        txtFuncionario.setEditable(false);

        lblFuncionario1.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        lblFuncionario1.setText("TRM del Día");

        txtTRM.setEditable(false);
        txtTRM.setHorizontalAlignment(JTextField.RIGHT);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblFuncionario)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFuncionario)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(lblFuncionario1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTRM)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(txtFuncionario)
                    .addComponent(lblFuncionario)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTRM)
                        .addComponent(lblFuncionario1)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Cliente", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), new Color(0, 153, 204))); // 

        lblTipo.setFont(new Font("Tahoma", 1, 11)); 
        lblTipo.setText("Tipo de Documento ");

        lblTiempo.setFont(new Font("Tahoma", 1, 11)); 
        lblTiempo.setText("Tiempo de Entrega");

        cbxDocumento.setModel(new DefaultComboBoxModel<>(new String[] 
        { "Básico", "Avanzado" }));
        cbxDocumento.setEnabled(false);
        cbxDocumento.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cbxDocumentoItemStateChanged(evt);
            }
        });

        cbxTiempo.setModel(new DefaultComboBoxModel<>(new String[] 
        { "Un día", "Entre 2 y 5 días", "Más de 5 días" }));
        cbxTiempo.setEnabled(false);
        cbxTiempo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cbxTiempoItemStateChanged(evt);
            }
        });

        lblCliente.setFont(new Font("Tahoma", 1, 11)); 
        lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCliente.setText("Nombre");

        lblEmail.setFont(new Font("Tahoma", 1, 11)); 
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmail.setText("E-mail");

        txtCliente.setEnabled(false);

        txtEmail.setEnabled(false);

        btnNueva.setText("Nueva");
        btnNueva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        
        jpControles.setBorder(BorderFactory.createTitledBorder(null, 
                "Controles de Navegación - Registro 0 de 0", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), 
                new Color(0, 153, 204))); 
   
        btnPrimero.setText("<<");
        btnPrimero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                activa = 1;
                activarNavegacion(jpControles,true, activa);
                actualizarVistaCotizacion(activa);
            }
        });
        
        btnAnterior.setText("<");
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                activa--;
                activarNavegacion(jpControles,true, activa);
                actualizarVistaCotizacion(activa);
            }
        });
        
        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                activa++;
                activarNavegacion(jpControles,true, activa);
                actualizarVistaCotizacion(activa);
            }
        });
        
        btnUltimo.setText(">>");
        btnUltimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                activa = cotizador.getCantidadCotizaciones();
                activarNavegacion(jpControles,true, activa );
                actualizarVistaCotizacion(activa);
            }
        });
        
        jpControles.add(btnPrimero);
        jpControles.add(btnAnterior);
        jpControles.add(btnSiguiente);
        jpControles.add(btnUltimo);
        

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNueva)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTipo)
                            .addComponent(lblCliente))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCliente)
                            .addComponent(cbxDocumento, 0, 131, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiempo)
                            .addComponent(lblEmail))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(cbxTiempo, 0, 166, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblEmail)
                    .addComponent(txtCliente)
                    .addComponent(txtEmail))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(lblTipo)
                    .addComponent(cbxDocumento)
                    .addComponent(lblTiempo)
                    .addComponent(cbxTiempo))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNueva)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Cotización No. ", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), 
                new java.awt.Color(0, 153, 204))); 

        txtCantidadArchivos.setEditable(false);
        txtCantidadArchivos.setHorizontalAlignment(JTextField.RIGHT);

        txtCantidadPalabras.setEditable(false);
        txtCantidadPalabras.setHorizontalAlignment(JTextField.RIGHT);

        txtCotizacionPesos.setEditable(false);
        txtCotizacionPesos.setHorizontalAlignment(JTextField.RIGHT);

        txtCotizacionDolares.setEditable(false);
        txtCotizacionDolares.setHorizontalAlignment(JTextField.RIGHT);

        jLabel1.setFont(new Font("Tahoma", 1, 11));  
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Total Palabras");

        jLabel2.setFont(new Font("Tahoma", 1, 11));  
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("Total de Archivos");

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Cotización Dolares");

        jLabel4.setFont(new Font("Tahoma", 1, 11)); 
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("Cotización Pesos");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, GroupLayout.Alignment.TRAILING, 
                            GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, 
                            GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, GroupLayout.Alignment.TRAILING, 
                            GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, GroupLayout.Alignment.TRAILING, 
                            GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidadArchivos, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(txtCantidadPalabras)
                    .addComponent(txtCotizacionDolares)
                    .addComponent(txtCotizacionPesos))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidadArchivos, GroupLayout.PREFERRED_SIZE, 
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtCantidadPalabras, GroupLayout.PREFERRED_SIZE, 
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtCotizacionDolares, GroupLayout.PREFERRED_SIZE, 
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtCotizacionPesos, GroupLayout.PREFERRED_SIZE, 
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Archivos", 
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, 
                new Font("Tahoma", 1, 12), 
                new Color(0, 153, 204))); 

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jlArchivos.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlArchivos.setEnabled(false);
        jScrollPane1.setViewportView(jlArchivos);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(jScrollPane1))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnAgregar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2)
                    .addComponent(jpControles)
                    .addComponent(jPanel1)       
                    
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4)))
                   
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpControles)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2)       
                
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5)
                    .addComponent(jPanel4))
                    
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }
}