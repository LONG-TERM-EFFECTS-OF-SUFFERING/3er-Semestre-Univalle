package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.modelo.Empresa;
import co.edu.univalle.vista.VistaEmpresa;
import java.util.ArrayList;


/**
 *
 * @author Yovany
 */

public class ControladorEmpresa {
    private Empresa modeloEmpresa;
    private VistaEmpresa vistaEmpresa;

    public ControladorEmpresa(VistaEmpresa vista, Empresa modelo) {
        modeloEmpresa = modelo;
        vistaEmpresa = vista;
        control();        
    }

    private void control() {
        int opc = 0;
        do {
            vistaEmpresa.interfaz();
            opc = vistaEmpresa.getOpcion();
            switch(opc) {
                case 1: vistaEmpresa.agregarEmpleado();
                        agregarEmpleado();
                        break;
                case 2: listarEmpleados(); break;
                case 3: vistaEmpresa.buscarEmpleado();
                        buscarEmpleado();
            }
        } while( opc != 5);
    }

    public void agregarEmpleado() {
        String nombre;
        double salario;
        
        nombre = vistaEmpresa.getNombre();
        salario = vistaEmpresa.getSalario();
        
        Empleado empleado = new Empleado(nombre, salario);
        
        if (modeloEmpresa.agregarEmpleado(empleado)){
            vistaEmpresa.mostrarMensajes("grabado");
        } else {
            vistaEmpresa.mostrarMensajes("Error");
        }
    }

    public void buscarEmpleado() {
        ArrayList<Empleado> listaEmpleados = modeloEmpresa.getListaEmpleados();
        String id = vistaEmpresa.getId();
        Empleado empleado = null;
        for(Empleado e : listaEmpleados){
            if(e.getId().equalsIgnoreCase(id)) {
                empleado = e;
                break;
            }
        }
        vistaEmpresa.mostrarEmpleado(empleado);
    }

    public void listarEmpleados() {
        ArrayList<Empleado> listaEmpleados = modeloEmpresa.getListaEmpleados();                      
        vistaEmpresa.listarEmpleados(listaEmpleados);
    }
}
