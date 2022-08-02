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

import java.util.*;


// Cuando trabajamos objetos en un solo archivo, solo debe haber una clase publica y un main
public class Video51_18 {
    public static void main(String[] args) {
        //Creemos un jefe
        Jefe JefeRRHH = new Jefe("Juan", 1500000, 2024, 12, 30);
        
        // Le damos un incentivo al jefe
        JefeRRHH.setIncentive(25700);
        
        // Creemos un empleado
        Empleado employee1 = new Empleado("Paco Gutierrez", 750000, 2022, 12 ,30);
        
        // Subamos el sueldo
        employee1.increaseSalary(5);
        
        System.out.println("Nombre: " + employee1.getName() + " Sueldo: " + employee1.getSalary() +
                " Fecha de alta: " + employee1.getRetirement());
        
        // Cuando manejemos varios empleados lo mejor es almacenarlos en un array
        Empleado[] myEmployees = new Empleado[5];
        
        myEmployees[0] =  JefeRRHH; // Aquí ya aplicamos polimorfismo; es una lista de empleados
        // pero estamos metiendo un jefe
        myEmployees[1] = new Empleado("Ximena Suarez", 850000, 2022, 8 ,30);
        myEmployees[2] = new Empleado("Alberto Angulo", 950000, 2022, 4 ,30);
        myEmployees[3] = employee1;
        myEmployees[4] = new Jefe("Maria", 1300000, 2025, 12, 30);
        // Para subirle el sueldo a "Maria" tenemos que hacer lo siguiente:
        Jefe jefaFinanzas = (Jefe) myEmployees[4]; // Estamos haciendo un casting
        // Si creamos los empleados sin parámetros, nos queda el objeto sin información (constructor por defecto)
        
        // Ahora si podemos darle un incentivo a "Maria"
        
        jefaFinanzas.setIncentive(50000);
        
        // Usamos el método que implementamos con la interfaz
        System.out.println(jefaFinanzas.takeADecision("Dar 3 días mas de vacaciones a los empleados"));

        // Damos y imprimimos los bonus a un jefe y un empleado
        System.out.println("La jefa " + jefaFinanzas.getName() + " tiene un bonus de " + jefaFinanzas.setBonus(500)
        + "$");
        
        System.out.println("El empleado " + myEmployees[2].getName() + "tiene un bonus de " + myEmployees[2].setBonus(200)
        + "$");
        
        // Este casting Jefe jefaCompras = (Jefe) myEmployees[0]; arroja un error, porque un empleado
        // no siempre es un jefe
        
        // Se recorren con un for
        for(Empleado miEmployee:myEmployees) {
            miEmployee.increaseSalary(5); // Esto también le incrementara el salario al jefe
            System.out.println("Nombre: " + miEmployee.getName() + " Sueldo: " + miEmployee.getSalary() +
                " Fecha de alta: " + miEmployee.getRetirement()); // Cuando llegamos al jefe el método getSalary
            // sera el de esa clase
        }
        
        System.out.println("Empleados ordenados según su sueldo");
        Arrays.sort(myEmployees); // Usamos el método que ya nos brinda la librería
        
        for(Empleado miEmployee:myEmployees) {
            System.out.println("Nombre: " + miEmployee.getName() + " Sueldo: " + miEmployee.getSalary() +
                " Fecha de alta: " + miEmployee.getRetirement());
        }        
    }
}

class Empleado implements Comparable, Trabajadores {
    
    private String name;
    private double salary;
    private Date   retirement;

    public Empleado(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        retirement = calendar.getTime(); // Ese método no esta exactamente en el objeto GregorianCalendar
        // lo hereda de Calendar
    }
    
    public Empleado(String name) {
        // Estamos aplicando sobre carga de constructores (usamos uno o otro constructor dependiendo
        // de los datos ingresados)
        this(name, 3000, 2000, 01, 01); // Este llama al otro constructor
        // Si no inicializo un objeto retorna null
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() { // Si volvemos este método final evitamos que en las clases que heredan
        // esta sobrescriban este método
        return salary;
    }
    
    public void increaseSalary(double percentage) {
        double increase = salary * percentage / 100;
        salary = salary + increase;
    }
    
    public Date getRetirement() {
        return retirement;
    }
    
    @Override
    public int compareTo(Object myObject) { // Usar la interfaz nos obliga a crear este método
        Empleado empleado = (Empleado) myObject; // Hacemos casting para poder comparar
        
        if(this.salary > empleado.salary) {
            return 1;
        } else if (this.salary < empleado.salary) {
            return -1;
        } else {
            return 0;
        }
        // No sabemos como funciona, esto es lo que solicita el creador de este método
    }
    
    @Override
    public double setBonus(double bonus) {
        return Trabajadores.baseBonus + bonus;
    }    
}

class Jefe extends Empleado implements Jefes { // Ya podemos observar que hay una "herencia" mas amplia
    private double incentive;
    
    public Jefe(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
    
    public void setIncentive(double incentive){
        this.incentive = incentive;
    }
    
    @Override
    public double getSalary(){
        double salary = super.getSalary(); // Dentro del objeto jefe llamamos el getSalary de la clase
        return salary + incentive; // padre
        // Como salary es un atributo privado de la clase padre no lo podemos llamar directamente
    }
    
    @Override
    public String takeADecision(String decision) { // Implementamos el método de la interfaz
        return "Un miembro administrativo a tomado la decision de " + decision;
    }
    
    @Override
    public double setBonus(double bonus) {
        double prima = 20000; // La prima solo la tienen los jefes
        return Trabajadores.baseBonus + bonus + prima; // accedemos a la constante de la interfaz trabajadores
    } 
}