package Clase30_06.Ejemplos;

import javax.swing.JOptionPane;


public class NumberFormatExample {   
    public void pedirNumero() {
        try {
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite su edad")); // Acepta cualquier
            // entero, incluidos los negativos
            System.out.println("Edad leida exitosamente: " + edad);
        } catch (NumberFormatException exc) {
            System.out.println("Ha ocurrido una excepcion");
            pedirNumero();            
        }     
    }
    
    public static void main(String a[]) {
        NumberFormatExample app = new NumberFormatExample();
        app.pedirNumero();   
   }
}
   
