package Clase07_07.tercero.modelo;

import java.io.Serializable;


public class Funcionario implements  Serializable{
    public static final long serialVersionUID = 1L;
    private String nombre;
    
    public Funcionario(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
}
