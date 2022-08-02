package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovany Romo
 */

public class Application extends JFrame {
    public Application() {
        initComponents();        
    }
    
    private void initComponents() {

        jMenuBar = new JMenuBar();
        jMenuFile = new JMenu();        
        jMenuOptions = new JMenu();
        jMenuHelp = new JMenu();
        jMenuItemSalir = new JMenuItem();
        jMenuItemAbout = new JMenuItem();
        jMenuItemEnrrollment = new JMenuItem();
        jMenuItemPerson = new JMenuItem();
        jDesktopPane = new JDesktopPane();
        
        
        jMenuFile.setText("File");        
        jMenuItemSalir.setText("Salir");        
        

        jMenuOptions.setText("Options"); 
        jMenuItemEnrrollment.setText("Enrollment");
        jMenuItemPerson.setText("Person");
        
        jMenuHelp.setText("Help");
        jMenuItemAbout.setText("About");        
        

        jMenuFile.add(jMenuItemSalir);
        jMenuOptions.add(jMenuItemEnrrollment);
        jMenuOptions.add(jMenuItemPerson);
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuOptions);
        jMenuBar.add(jMenuHelp);
        
        setJMenuBar(jMenuBar);        
        
        ManejadoraEventos manejadorEventos = new ManejadoraEventos();
        jMenuItemSalir.addActionListener(manejadorEventos);                
        jMenuItemAbout.addActionListener(manejadorEventos); 
        jMenuItemEnrrollment.addActionListener(manejadorEventos); 
        jMenuItemPerson.addActionListener(manejadorEventos);
        
        add(jDesktopPane);

        setTitle("Interfaces Gráficas");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }                     

    private class ManejadoraEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jMenuItemSalir){
                System.exit(0);
            }else if( e.getSource() == jMenuItemAbout){
                JOptionPane.showMessageDialog(null, "Interfaces Gráficas 1.0");
            }else if( e.getSource() == jMenuItemEnrrollment){
                callEnrollment();      
            }else if( e.getSource() == jMenuItemPerson){
                callPerson();      
            }
        }
        
    }
    
    private void callEnrollment() {  
        
        if(enrrollmentWindow == null){
            enrrollmentWindow = new Enrrollment();       
            jDesktopPane.add(enrrollmentWindow);
        }   
        
        int x = (jDesktopPane.getWidth() / 2) - enrrollmentWindow.getWidth() /2;
        int y = (jDesktopPane.getHeight() / 2) - enrrollmentWindow.getHeight() /2;
        
        enrrollmentWindow.setLocation(x,y);
        enrrollmentWindow.setVisible(true);
    }
    
    private void callPerson() {  
        
        if(personWindow == null){
            personWindow = new Person();       
            jDesktopPane.add(personWindow);
        }   
        
        int x = (jDesktopPane.getWidth() / 2) - personWindow.getWidth() /2;
        int y = (jDesktopPane.getHeight() / 2) - personWindow.getHeight() /2;
        
        personWindow.setLocation(x,y);
        personWindow.setVisible(true);
    }
    
    private JMenu jMenuFile;
    private JMenu jMenuOptions;
    private JMenu jMenuHelp;

    private JMenuBar jMenuBar;
    private JMenuItem jMenuItemSalir;
    private JMenuItem jMenuItemAbout;
    private JMenuItem jMenuItemEnrrollment;
    private JMenuItem jMenuItemPerson;
    
    private JDesktopPane jDesktopPane;
    
    Enrrollment enrrollmentWindow = null;
    Person personWindow = null;
    
}


