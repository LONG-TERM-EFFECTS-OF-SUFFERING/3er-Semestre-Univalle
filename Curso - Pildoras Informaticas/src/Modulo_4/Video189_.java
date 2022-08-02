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

package Modulo_4;

import java.util.*;

public class Video189_ {
    public static void main(String[] args) {
        HashMap<String, Employee> employees = new  HashMap<>();
        
        employees.put("145", new Employee("Juan"));
        employees.put("146", new Employee("Maria"));
        employees.put("147", new Employee("Pepe"));
        employees.put("148", new Employee("Camila"));
        
        System.out.println(employees);
        
        employees.remove("147"); // Eliminar elemento
        
        System.out.println(employees);
        
        employees.put("148", new Employee("Nathalia")); // Como ya hay un elemento con esa clave, este
        // sera reemplazado
        
        for(Map.Entry<String, Employee> input:employees.entrySet()) { // employees.entrySet() devuelve los 
            // empleados en un Set
            String key = input.getKey();
            Employee value = input.getValue();
            
            System.out.println("Llave: " + key + " Value: " + value);
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name) {
        this.name = name;
        salary = 2000;
    }
    
    @Override
    public String toString() {
        return "[nombre = " + name + ", sueldo = $" + salary + "]";
    }
    
}
