package Clase23_06.Ejemplos.Segundo.Logica;


public class Empleado {
    private String ID;
    private String nombre;
    private String cargo;
    private int salario;

     public Empleado() {
        this.ID = "";
        this.nombre = "";
        this.cargo = "";
        this.salario = 0;
    }
     
    public Empleado(String ID, String nombre, String cargo, int salario) {
        this.ID = ID;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }
    /* No usamos esta clase
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    */
}
