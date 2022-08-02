package Clase23_06.Ejemplos.Quinto.Logica;

import java.util.ArrayList;


public class Empresa {
    private String razonSocial;
    private ArrayList <Empleado> listadoEmpleados;

    public Empresa(String razonSocial) {
        this.listadoEmpleados = new ArrayList<>();
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }    
    
    public void agregarEmpleado(Empleado empleado){
        listadoEmpleados.add(empleado);
    }
    
    public ArrayList <Empleado> getListadoEmpleados(){
        return listadoEmpleados;
    }       
}
