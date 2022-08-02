package Clase23_06.Ejemplos.Quinto.Logica;


public class Empleado {
    private static int numero;
    private int codigo;
    private String nombres;
    private String apellidos;

    public Empleado(String nombres, String apellidos) {
        numero++;
        this.codigo = numero;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public static int getNumero() {
        return numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
   
    @Override
    public String toString(){
        return "[" + codigo + " , " + nombres + " , " + apellidos + "]" ;
    }
}
