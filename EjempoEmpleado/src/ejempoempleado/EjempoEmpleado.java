package ejempoempleado;

import co.edu.univalle.controlador.ControladorEmpresa;
import co.edu.univalle.modelo.Empresa;
import co.edu.univalle.vista.VistaEmpresa;

/**
 *
 * @author Yovany
 */

public class EjempoEmpleado {
    public static void main(String[] args) {
        VistaEmpresa vistaEmpresa = new VistaEmpresa();
        Empresa empresaModelo = new Empresa();
        
        ControladorEmpresa controlador = 
                new ControladorEmpresa(vistaEmpresa, empresaModelo);
    }
}
