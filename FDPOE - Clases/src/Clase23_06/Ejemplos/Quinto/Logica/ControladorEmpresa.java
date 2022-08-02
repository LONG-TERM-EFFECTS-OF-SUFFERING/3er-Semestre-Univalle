package Clase23_06.Ejemplos.Quinto.Logica;

import java.util.ArrayList;
import java.util.Scanner;


public class ControladorEmpresa {
    private Empresa empresa;

    public ControladorEmpresa() {
        this.empresa = new Empresa("UNAL");
    } 
    
    public void control(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        
        do {            
            System.out.println("Gestion de Empresa " + empresa.getRazonSocial());
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Listado de Empleados");
            System.out.println("3. Buscar Empleado - Código");
            System.out.println("4. Modificar Datos Empleado - Código");
            System.out.println("5. Eliminar Empleado - Código");
            System.out.println("6. Salir");
            System.out.println("Opcion : ");
            opcion = sc.nextByte();
            switch(opcion) {
                case 1: 
                    agregarEmpleado(); 
                    System.out.println("Empleado Agregado con éxito");
                    break;
                case 2: 
                    listarEmpleados(); break;
            }
        } while (opcion != 6);
        System.out.println("Gracias!!!!");
    }
    
    private void agregarEmpleado() {
        String nombres = "";
        String apellidos = "";
        Scanner sc = new Scanner(System.in);
        // Capurar los datos nombres y apellidos
        System.out.print("Nombres: ");
        nombres = sc.nextLine();
        System.out.print("Apellidos: ");
        apellidos = sc.nextLine();
        // Creamos el objeto con los datos ingresados
        Empleado empleado = new Empleado(nombres, apellidos);
        // Lo agregamos a la empresa
        empresa.agregarEmpleado(empleado);
    }
    
    private void listarEmpleados() {
        ArrayList<Empleado> listado = empresa.getListadoEmpleados();
        
        if(listado.isEmpty()) {
            System.out.println("No hay empleados contratados");
        } else {
            listado.forEach((empleado)-> {
                System.out.println(empleado);
            });
            
            /* Otras formas de enlistar los empleados
            for (int i = 0; i < listado.size(); i++) {
                System.out.println(listado.get(i));
            }
            
            for(Empleado empleado : listado){
                System.out.println(empleado);
            }
            */
        }
    }
}
