
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

import java.awt.Image;
import javax.swing.*;

public class Video100_29 {
    public static void main(String[] args) {
        myFrame26 window = new myFrame26();        
    }
}

class myFrame26 extends JFrame {
    public myFrame26() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Probando los MenuBar");
                
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel22 myPanel = new Panel22();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel22 extends JPanel {
    // Para redimensionar una imagen se hace lo siguiente
    String path = "src/Modulo_2/Icon.jpg"; 
    ImageIcon icon = new ImageIcon(path);
    Image resizedImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Sacamos la imagen del icono
    // porque leerla desla la clase Image es muy engorroso (instaciar un File y leerlo)
    ImageIcon resizedIcon = new ImageIcon(resizedImage);
    
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("Archivo");
    JMenu edition = new JMenu("Edicion");
    JMenu tools = new JMenu("Herramientas");
    JMenu options = new JMenu("Opciones");
    JMenuItem save = new JMenuItem("Guardar", new ImageIcon(path));
    JMenuItem save_as = new JMenuItem("Guardar como", resizedIcon);
    JMenuItem cut = new JMenuItem("Cortar", new ImageIcon("src/Modulo_2/Icons - Editor/cut.png"));
    JMenuItem copy = new JMenuItem("Copiar", new ImageIcon("src/Modulo_2/Icons - Editor/copy.png"));
    JMenuItem paste = new JMenuItem("Pegar", new ImageIcon("src/Modulo_2/Icons - Editor/paste.png"));
    JMenuItem general = new JMenuItem("Generales");
    JMenuItem option1 = new JMenuItem("opcion");
    JMenuItem option2 = new JMenuItem("opcion2");
    
    public Panel22() {
        menuBar.add(file);
        menuBar.add(edition);
        menuBar.add(tools);
        
        options.add(option1);
        options.add(option2);
        
        file.add(save);
        file.add(save_as);
        
        edition.add(cut);
        edition.add(copy);
        edition.add(paste);
        edition.addSeparator(); // Agrega un separador (decoracion)
        edition.add(options); // Tambien podemos agregar Menus en los Menus
               
        tools.add(general);
     
        add(menuBar);          
    }
}
