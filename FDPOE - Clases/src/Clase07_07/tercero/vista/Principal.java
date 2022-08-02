package Clase07_07.tercero.vista;

public class Principal {
    public static void main(String[] args) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);                
            }
        });
    }
}
