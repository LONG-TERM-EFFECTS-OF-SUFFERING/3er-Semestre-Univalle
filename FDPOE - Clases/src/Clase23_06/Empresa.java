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

/**
 *  CLASE:     Empresa
 *  INTENCION: Representar una empresa.
 *  RELACION:  NINGUNA 
 */


public class Empresa {
    private ArrayList<Empleado> employeesList;
    
    public Empresa(ArrayList<Empleado> employeesList) {
        this.employeesList = employeesList;
    }
    
    public float averageSalary() {
        float sum = 0;
        
        for(Empleado employee : employeesList) {
            sum += employee.getSalary();
        }      
        return sum / employeesList.size();
    }
    
    public void higherSalary() {
        Empleado initialEmployee = new Empleado();
        
        for(Empleado employee : employeesList) {
            if(employee.getSalary() > initialEmployee.getSalary()) {
                initialEmployee = employee;
            }
        }
        System.out.println("---Empleado con el salario mas alto---");
        System.out.println("Nombre: " + initialEmployee.getName());
        System.out.println("Salario: " + initialEmployee.getSalary());
    }
        
    public void higherThanAverage() {
        float averageSalary = this.averageSalary();
        
        System.out.println("---Empleado con un salario mayor al promedio---");
        
        for(Empleado employee : employeesList) {
            if(employee.getSalary() > averageSalary) {
                System.out.println(employee.getName());
            }
        }      
    }
    
    public void employeesByPosition(String position) {
        System.out.println("---Empleados en el cargo de " + position + "---");
        for(Empleado employee : employeesList) {
            if(position.equals(employee.getPosition())) {
                System.out.println(employee.getSalary());
            }
        }
    }
}

