package Clase23_06.Ejemplos.Primero.Logica;


public class Persona {
    private int cedula;
    private String nombres;

    public Persona(int cedula, String nombres) {
        this.cedula = cedula;
        this.nombres = nombres;
    }
    
    // Vamos a usar este metodo general para mostrar la informacion en el main
    public String showInformation() {
       return "Cedula : " + cedula + " | Nombre : " + nombres; 
    }
    
    /* Este es el metodo que usa java para mostrarlo en un print
    @Override
    public String toString() {
       return "Cedula : " + cedula + " | Nombre : " + nombres; 
    }
    */
}
