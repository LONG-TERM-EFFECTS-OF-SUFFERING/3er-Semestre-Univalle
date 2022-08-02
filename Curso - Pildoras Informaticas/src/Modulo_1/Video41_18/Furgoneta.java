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

package Modulo_1.Video41_18;

/**
 *  CLASE:     Furgoneta 
 *  INTENCION: Representar una furgoneta
 *  RELACION:  NINGUNA 
 */

public class Furgoneta extends Coche { // En java Coche seria super clase y Furgoneta subclase
    // Java no admite herencia multiple, es decir, solo puede haber un extends
    private int chargeCapacity;
    private int seats;

    public Furgoneta(int chargeCapacity, int seats) {
        super(); // Llamamos al constructor de la clase padre
        // Ahora asignamos lo propio de esta clase
        this.chargeCapacity = chargeCapacity;
        this.seats = seats;
    }

    public String getFurgonetaData() {
        return "La capacidad de carga es " + chargeCapacity + "y tiene " + seats ;    
    }
}
