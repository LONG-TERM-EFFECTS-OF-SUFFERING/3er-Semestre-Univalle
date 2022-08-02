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

package Modulo_1;

public class Video46_20 {
    public static void main(String[] args) {
        Persona[] myPersons = new Persona[2];
        
        myPersons[0] = new Empleado2("Juan", 900000, "RRHH");
        myPersons[1] = new Estudiante("Nathalia", "Ing. de sistemas");
        
        for(Persona persona:myPersons) {
            System.out.println(persona.getDescription());
        }
    }
}

abstract class Persona {  
    private String name;
    
    public Persona(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    } 
    
    public abstract String getDescription();
}

class Empleado2 extends Persona { // Ya tenemos un archivo con una clase empleado en "19"
    private double salary;
    private String section;
    
    public Empleado2(String name, double salary, String section) {
        super(name);
        this.salary = salary;
        this.section = section;
    }
    
    @Override
    public String getDescription() { // Por obligación tenemos que sobrescribir este método
        return "Esta persona es un empleado llamado " + super.getName() + ", que tiene un salario de " + salary + "$ y"
                + " trabaja en " + section;
    }
}

class Estudiante extends Persona {
    private String career;
    
    public Estudiante(String name, String career) {
        super(name);
        this.career = career;
    }
    
    @Override
    public String getDescription() { // Por obligación tenemos que sobrescribir este método
        return "El estudiante " + super.getName() + " esta en la carrera de " + career;
    }
}
