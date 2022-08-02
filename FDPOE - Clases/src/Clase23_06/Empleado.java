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

/**
 *  CLASE:     Empleado
 *  INTENCION: Representar el empleado en una empresa.
 *  RELACION:  NINGUNA 
 */


public class Empleado {
    private String name;
    private String position;    
    private float salary;

    public Empleado() {
        
    }
    
    public Empleado(String name, String position, float salary) { // El constructor tambien es el setter
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }    
}

