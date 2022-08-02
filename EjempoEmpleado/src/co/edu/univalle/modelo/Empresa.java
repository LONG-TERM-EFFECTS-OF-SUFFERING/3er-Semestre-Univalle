package co.edu.univalle.modelo;

import java.util.ArrayList;

/**
 *
 * @author Yovany
 */

public class Empresa {
    private ArrayList<Empleado> listaEmpleados;
    
    public Empresa() {
        this.listaEmpleados = new ArrayList<>();
    }

    public Empresa(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
        return true;
    }
}
