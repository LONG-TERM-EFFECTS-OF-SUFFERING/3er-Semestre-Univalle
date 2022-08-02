package Clase23_06.Ejemplos.Quinto.Empresa;

import Clase23_06.Ejemplos.Quinto.Logica.ControladorEmpresa;


public class Principal {
    public static void main(String[] args) {
        /*
        System.out.println(Empleado.getNumero());
        Empleado emp1 = new Empleado("Pepito", "Diaz");
        System.out.println(Empleado.getNumero());
        Empleado emp2 = new Empleado("Juanito", "Torres");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(Empleado.getNumero());   
        */
        ControladorEmpresa controladorEmpresa = new ControladorEmpresa();
        controladorEmpresa.control();
    }
}
