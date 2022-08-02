package Clase23_06.Ejemplos.Segundo.Logica;

import java.util.ArrayList;


public class Empresa {
    private String razonSocial;
    private String nit;
    private ArrayList<Departamento> departamentos;
    
    public Empresa() {
        this.razonSocial = "";
        this.nit = "";
        this.departamentos = new ArrayList();
    }
    
    public Empresa(String razonSocial, String nit) {
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.departamentos = new ArrayList();
    }
    
    public Empresa(String razonSocial, String nit, ArrayList departamentos) {
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.departamentos = departamentos;
    }
    
    public void agregarDepartamentos() {       
       departamentos.add(new Departamento("Logistica"));
       departamentos.add(new Departamento("Operaciones"));
       departamentos.add(new Departamento("Mercadeo"));
    }
    
    public void listadoDepartamentos() {
        for(Departamento departamento:departamentos){
            System.out.println(departamento.getNombre());
        }
    }    
}
