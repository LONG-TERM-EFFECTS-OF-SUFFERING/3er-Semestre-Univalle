/*
                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ Brandon Calderón Prieto  
       .---.         
      /     \   calderon.brandon@correounivalle.edu.co     
      \.@-@./               
      /`\_/`\               202125974
     //  _  \\        
    | \     )|_        Ingeniería de sistemas
   /`\_`>  <_/ \
   \__/'---'\__/
 */

package Clase23_06;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Se crean a los empleados
        Empleado empleado1 = new Empleado("Mauricio", "Auxiliar", 4500);
        Empleado empleado2 = new Empleado("Brayan", "Ingeniero", 1000);
        Empleado empleado3 = new Empleado("Brandon", "Ingeniero", 2000);
        Empleado empleado4 = new Empleado("Deivid", "Veterinario", 500);
        Empleado empleado5 = new Empleado("Camila", "Licenciado", 1080);
        Empleado empleado6 = new Empleado("Julian", "Doctor", 6000);
        Empleado empleado7 = new Empleado("Isabela", "Licenciado", 8340);
        Empleado empleado8 = new Empleado("Pepe", "Doctor", 100);
        Empleado empleado9 = new Empleado("Robert", "Doctor", 1000);
        Empleado empleado10 = new Empleado("Daniela", "Ingeniero", 2000);
        
        // Se añaden a un array
        ArrayList<Empleado> listado = new ArrayList<>();
        
        listado.add(empleado1);
        listado.add(empleado2);
        listado.add(empleado3);
        listado.add(empleado4);
        listado.add(empleado5);
        listado.add(empleado6);
        listado.add(empleado7);
        listado.add(empleado8);
        listado.add(empleado9);
        listado.add(empleado10);
        
        // Se crea la empresa y se le ingresa el listado
        Empresa miEmpresa = new Empresa(listado);
        
        System.out.println("El salario promedio de los empleados de la empresa es de " + 
                miEmpresa.averageSalary() + " $");
        miEmpresa.higherSalary();
        miEmpresa.higherThanAverage();
        miEmpresa.employeesByPosition("Auxiliar");
    }
    
}