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

package Modulo_1.Video41_18; // Estamos usando el mismo paquete que donde esta la clase Coche 
// (por lo que ya esta importada)

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        Coche Renault = new Coche();
        
        // Renault.numeroRuedas = 2; // Con los métodos públicos es posible esto, no estaríamos
        // implementando encapsulamiento
        Renault.setColor(JOptionPane.showInputDialog("Cual es el color de su coche ?")); // Si pedimos 
        // el color de un coche sin establecerlo nos retorna  null
        System.out.println(Renault.getColor());
        
        Renault.setAsientos(JOptionPane.showInputDialog("Tiene asientos de cuero ?"));
        System.out.println(Renault.getAsientos());
        
        Renault.setClimatizador(JOptionPane.showInputDialog("Tiene climatizador ?"));
        System.out.println(Renault.getClimatizador());
        
        System.out.println(Renault.getPesoTotal());
        
        System.out.println(Renault.getDatosGenerales());
        
        System.out.println(Renault.precioCoche());
        
        // Nos basamos en el esquema de herencia "es un" MAL IMPLEMENTADO (debio tratarse con
        // una clase vehiculo, las furgonetas no son carros)
        Furgoneta miFurgoneta = new Furgoneta(7, 580);
        miFurgoneta.setColor("azul");
        miFurgoneta.setAsientos("Si");
        miFurgoneta.setClimatizador("Si");
        System.out.println(miFurgoneta.getDatosGenerales() + " " + miFurgoneta.getFurgonetaData());  
    }
}
