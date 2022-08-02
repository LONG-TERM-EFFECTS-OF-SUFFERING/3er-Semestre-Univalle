package Clase23_06.Ejemplos.Segundo.Logica;

import java.util.ArrayList;


public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento() {
        this.nombre = "";
        this.empleados = null;
    }
    
    // Sobrecarga de constructores
     public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = null;
    }
    
    public Departamento(String nombre, ArrayList <Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }
    
    public void agregarEmpleados(ArrayList <Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
}
