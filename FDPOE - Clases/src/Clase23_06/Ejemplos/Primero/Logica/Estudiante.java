package Clase23_06.Ejemplos.Primero.Logica;


public class Estudiante extends Persona {
    private String carrera;
    
    public Estudiante(int cedula, String nombres, String carrera) {
        super(cedula, nombres); // Llamamos al constructor padre
        this.carrera = carrera;
    }   
    
    @Override
    public String showInformation() {
        return super.showInformation() + " | Carrerar : " + carrera;
    }
}
