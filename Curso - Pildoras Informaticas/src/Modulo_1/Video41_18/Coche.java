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
 *  CLASE:     Coche  
 *  INTENCION: Representar un coche de ciertas características
 *  RELACION:  NINGUNA 
 */

public class Coche {
    // int numeroRuedas, largo, ancho, motor, peso; // Estas características son publicas (se accede con ".")
    private int numeroRuedas, largo, ancho, motor, pesoPlataforma, pesoTotal; // Ahora le añadimos un modificador de acceso
    // En la linea anterior establecimos lo general de cada coche, ahora declaremos lo que puede cambiar en cada uno
    private String color;
    private boolean asientosCuero, climatizador;
    
    public Coche() { 
        numeroRuedas    = 4;
        largo           = 2000;
        ancho           = 300;
        motor           = 1600;
        pesoPlataforma  = 500;
    }
    
    public int getNumeroRuedas() { // Getter - retorna algo
        return numeroRuedas;
    }
    
    public void setColor(String color) { // Setter - no retorna nada, ademas le pasamos argumentos
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getDatosGenerales() {
        return "La plataforma del vehiculo tiene " + numeroRuedas + ". Mide " + largo / 1000 + " metros con"
                + " un ancho de " + ancho + " cm y un peso de plataforma de " + pesoPlataforma + " kg";
    }
    
    public void setAsientos(String asientosCuero) {        
        this.asientosCuero = "si".equalsIgnoreCase(asientosCuero); // Ignoramos mayúsculas
    }
    
    public String getAsientos() {
        if(asientosCuero) {
            return "El coche tiene asientos de cuero";
        } else {
            return "El coche tiene asientos de serie";
        }
    }
    
    public void setClimatizador(String climatizador) {
        this.climatizador = "si".equalsIgnoreCase(climatizador); // Ignoramos mayúsculas
    }
    
    public String getClimatizador() {
        if(climatizador) {
            return "El coche incorpora climatizador";
        } else {
            return "El coche lleva aire acondicionado";
        }
    }
    
    public String getPesoTotal() {
        int precioCarroceria = 500;
                
        pesoTotal = pesoPlataforma + precioCarroceria;
        
        if(asientosCuero) {
            pesoTotal += 50;
        }
        
        if(climatizador) {
            pesoTotal += 20;
        }
        return "El peso total del coche es " + pesoTotal + " kg";
    }
    
    public int precioCoche() {
        int precioFinal = 10000;
        
        if(asientosCuero) {
            precioFinal += 2000;
        }
        
        if(climatizador) {
            precioFinal += 1500;
        }        
        return precioFinal;
    }
    // Método setter y getter a la vez(no es recomendable en el paradigma)
    /*
    Esto no es recomendable hacerlo, la idea es modularizar un programa
    public static void main(String[] args) {
        Coche Renault = new Coche();
        
        System.out.println("Este coche tiene " + Renault.numeroRuedas + " Ruedas");
    }
    */
}


