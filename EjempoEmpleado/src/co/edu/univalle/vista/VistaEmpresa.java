package co.edu.univalle.vista;

import co.edu.univalle.modelo.Empleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Yovany
 */

public class VistaEmpresa {
    private String id;
    private String nombre;
    private double salario;
    private int opcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    
    public void interfaz() {
        opcion = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONE OPCION\n"+
                "1. Agregar Empleados \n"+
                "2. Listar Empleados \n"+
                "3. Buscar Empleados \n"+
                "5. Salir"));                            
    }
    
    public void agregarEmpleado() {                
        nombre = JOptionPane.showInputDialog("Nombre");
        salario = Double.parseDouble(JOptionPane.showInputDialog("Salario"));        
    }
    
    public void buscarEmpleado() {
        id = JOptionPane.showInputDialog("Código de Empleado a Buscar");
    }
    
    public void listarEmpleados(ArrayList<Empleado> listaEmpleados) {
        JTextArea pantalla = new JTextArea(20,40);
        JScrollPane desplaza = new JScrollPane(pantalla);
        pantalla.append("LISTADO DE EMPLEADOS\nCodigo\tEmpleado\tSalario\n");
        for(Empleado empleado : listaEmpleados){
            pantalla.append(empleado.getId() +"\t" +
                    empleado.getNombre() + "\t" + 
                    empleado.getSalario() + "\n");
        }
        JOptionPane.showMessageDialog(null, desplaza);
    }
    
    public void mostrarEmpleado(Empleado empleado) {
        if(empleado == null) {
            JOptionPane.showMessageDialog(null, "Empleado con código " + ID + 
                    " no encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "DATOS DE EMPLEADO\n"+
                    "Nombre  : " + empleado.getNombre() +"\n" +
                    "Salario : " + empleado.getSalario());
        }            
    }

    public void mostrarMensajes(String estado) {
        switch(estado) {
            case "grabado":
                JOptionPane.showMessageDialog(null, 
                        "Registro Grabado con Éxito",
                        "Resultado de Acción", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "error":
                JOptionPane.showMessageDialog(null, 
                        "Error al realizar la transacción",
                        "Resultado de Acción", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
