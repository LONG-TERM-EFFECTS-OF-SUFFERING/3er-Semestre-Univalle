package co.edu.univalle.modelo;

/**
 *
 * @author Yovany
 */

public class Empleado {
    private static int contador;
    private String ID;
    private String nombre;
    private double salario;

    private Empleado() {
        ++contador;
    }   

    public Empleado(String nombre, double salario) {
        this();
        this.ID = String.valueOf(contador);
        this.nombre = nombre;
        this.salario = salario;
    }        

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ID=" + ID + ", nombre=" + nombre + ", salario=" + salario + '}';
    }        
}
