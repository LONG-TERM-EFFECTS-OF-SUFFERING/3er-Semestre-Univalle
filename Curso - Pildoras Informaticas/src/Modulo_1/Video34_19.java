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

public class Video34_19 {
    public static void main(String[] args) {
        // Veamos en la practica el uso de final (constantes)
        Empleado employee1 = new Empleado("Pepe");
        System.out.println(employee1.getData());
        
        employee1.setSection("RRHH");
        System.out.println(employee1.getData());
        
        Empleado employee2 = new Empleado("Maria");
        System.out.println(employee2.getData());
        
        System.out.println(Empleado.getNextID()); // Al ser el método estático, se le aplica a la  
        // clase y no a un objeto
    }
}

class Empleado {
    // En la practica vemos que un empleado no puede cambiar su nombre, entonces lo declaramos
    // como final
    final   String     name;
    private String     section;
    private int        ID;
    private static int nextID = 1; // Esto nos va a servir como especie de contador
    
    public Empleado(String name) {
        this.name = name;
        section   = "Administración";
        ID        = nextID;
        nextID++; // Aumentamos el "contador"
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    public String getSection() {
        return section;
    }
/*    
    public void setName(String name) { // Este método nos marca error por la naturaleza del nombre
        this.name = name;
    }
*/    
    public static int getNextID() { // Con métodos estáticos solo podemos acceder a atributos estáticos
        return nextID++;
    }
    
    public String getData() {
        return "El nombre es " + name + ", su sección es " + section + " y su ID es " + ID;
    }
}