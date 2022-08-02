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

package Modulo_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class Video108_31 {
    public static void main(String[] args) {
        MyFrame27 window = new MyFrame27();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFrame27 extends JFrame {
    public MyFrame27() {
        setTitle("Editor de texto");
               
        setSize(300, 400);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel22 myPanel = new Panel22();       
        add(myPanel);
        setVisible(true);
    }
}

class Panel22 extends JPanel {
    JToolBar toolBar = new JToolBar();
    private JTextPane textPane = new JTextPane();
    private JMenu font = new JMenu("Fuente"), style = new JMenu("Estilo"), size = new JMenu("Tamaño");
    private ButtonGroup sizes = new ButtonGroup();
    
    public Panel22() {
        setLayout(new BorderLayout());
        
        JPanel menu = new JPanel();
        
        JMenuBar menuBar = new JMenuBar();
        
        // ------------------------------------------ //
        addMenuItem("Arial", font);
        addMenuItem("Courier", font);
        addMenuItem("Verdana", font);
        // ------------------------------------------ //
        addMenuItem("Negrita", style);
        addMenuItem("Cursiva", style);
        // ------------------------------------------ //
        addMenuItem("12", size);
        addMenuItem("16", size);
        addMenuItem("20", size);
        addMenuItem("24", size);
                  
        menuBar.add(font);
        menuBar.add(style);
        menuBar.add(size);
        
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem boldOption = new JMenuItem("Negrita");
        boldOption.addActionListener(new StyledEditorKit.BoldAction());
        popupMenu.add(boldOption);
        
        JMenuItem italicOption = new JMenuItem("Cursiva");
        italicOption.addActionListener(new StyledEditorKit.ItalicAction());
        popupMenu.add(italicOption);
        // Como no estan comunicados con las casillas del JMenu, los cambios aqui no se ven
        // reflejados en ese menu
        textPane.setComponentPopupMenu(popupMenu); // Se le aplica a componentes, en este caso el panel
        // ------------------------------------------ //
        
        toolBar.setOrientation(1); // 0 - Horizontal / 1 - Vertical
        
        addButton("src/Modulo_2/Icons - Editor/negrita.png").addActionListener(new StyledEditorKit.BoldAction());
        addButton("src/Modulo_2/Icons - Editor/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
        addButton("src/Modulo_2/Icons - Editor/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
        toolBar.addSeparator();
        addButton("src/Modulo_2/circulo_amarillo.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner amarillo", Color.YELLOW));
        addButton("src/Modulo_2/circulo_azul.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner azul", Color.BLUE));
        addButton("src/Modulo_2/circulo_rojo.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner rojo", Color.RED));
        toolBar.addSeparator();
        addButton("src/Modulo_2/Icons - Editor/center_align.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrar", 1));
        addButton("src/Modulo_2/Icons - Editor/right_align.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        addButton("src/Modulo_2/Icons - Editor/left_align.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 3));
        addButton("src/Modulo_2/Icons - Editor/justify_align.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificar", 4));
                              
        add(menuBar, BorderLayout.NORTH);
        add(toolBar, BorderLayout.WEST);
        add(textPane, BorderLayout.CENTER);
    }
    
    private JButton addButton(String path) {
        JButton button = new JButton(new ImageIcon(path));
        toolBar.add(button);
        
        return button;
    }
    
    private void addMenuItem(String name, JMenu menu) {        
        if(menu == font) {
            JMenuItem menuItem = new JMenuItem(name);
            menuItem.addActionListener(new StyledEditorKit.FontFamilyAction("Change fontFamily", name.toLowerCase()));
            menu.add(menuItem);
        } else if(menu == style) {
            JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem(name, new ImageIcon("src/Modulo_2/Icons - Editor/" + name.trim() + ".png"));
            
            if(name.equals("Negrita")) {
                checkBoxItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                checkBoxItem.addActionListener(new StyledEditorKit.BoldAction());
            } else { // Caso cursiva
                checkBoxItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                checkBoxItem.addActionListener(new StyledEditorKit.ItalicAction());
            }
            menu.add(checkBoxItem);          
        } else { // Caso size
            JRadioButtonMenuItem radioButtonItem = new JRadioButtonMenuItem(name);            
            sizes.add(radioButtonItem);
            
            int sizeNumber = Integer.parseInt(name);
            radioButtonItem.addActionListener(new StyledEditorKit.FontSizeAction("Change size", sizeNumber));
            
            menu.add(radioButtonItem);
        }          
    }
   
}