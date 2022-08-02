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
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Video85_19 {
    public static void main(String[] args) {
        Calculadora window = new Calculadora();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Calculadora extends JFrame {
    public Calculadora() {
        setTitle("Calculadora");
        
        
        setSize(400, 600);
        setLocationRelativeTo(null); // Centrarlo en la pantalla
        
        Panel12 myPanel = new Panel12();       
        add(myPanel);
        setVisible(true); // Para que la ponga visible cuando se agregue el panel
    }  
}

class Panel12 extends JPanel {
    private JPanel buttons;
    private JPanel top;
    private boolean beginning = true;
    private double result = 0;
    String lastOperator = "Resultado"; // Para que el primera entrada sea almacenada en "result"
    JButton screen = new JButton("0");
    JButton showResult = new JButton("Resultado");
    
    public Panel12() {
        setLayout(new BorderLayout());
        
        screen.setEnabled(false);
        
        showResult.addActionListener(new actionListener2());
                
        top = new Panel();
        top.setLayout(new GridLayout(2, 1));
        top.add(screen);
        top.add(showResult);
               
        add(top, BorderLayout.NORTH);
        
        buttons = new Panel();
        buttons.setLayout(new GridLayout(4, 4));
        
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");
        addButton("C");
        addButton("0");
        addButton(".");
        addButton("+");        
        add(buttons, BorderLayout.CENTER);      
    }
    
    private void addButton(String label) {
        JButton button = new JButton(label);
        // Comprobemos que sea un numbero o el "."
        
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(label);
        
        // Condicional para separar los botones de operaciones de los numeros
        if(!matcher.matches() && !label.equals(".")) {
            System.out.println(label);
            button.addActionListener(new actionListener2());
        } else { // Para numeros
            button.addActionListener(new actionListener());
        }
        
        buttons.add(button);        
    }

    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(beginning) { // Condicional para quitar el 0 del principio
                screen.setText("");
                beginning = false;
            }
            String input = e.getActionCommand(); // Extraemos el texto del boton
            screen.setText(screen.getText() + input); // Mostamos lo que estaba antes mas lo que presione
        }
        
    }
    
    private class actionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {         
            String operator = e.getActionCommand();
            if(operator.equals("C")) {
                result = 0;
                screen.setText("0");               
            } else {
                calculate(Double.parseDouble(screen.getText()));
            
                lastOperator = operator; // Se asigna despues porque la operacion se hace con el 
                // segundo numero                            
            }
            beginning = true; 
        }       
    }
    
    private void calculate(double number) {
              
        switch (lastOperator) {
            case "Resultado" -> result = number;
            case "+" -> result += number;
            case "-" -> result -= number;
            case "*" -> result *= number;
            case "/" -> result /= number;         
            default -> {
            }
        }
        System.out.println("Numero: " + number + " Resultado acumulado: " + result);  
        screen.setText(Double.toString(result));
    }
}