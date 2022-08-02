package Clase23_06.Ejemplos.Segundo.Logica;


public class ControladorEmpresa {
    
    private Empresa empresa ;
    
    public ControladorEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
   
    public void controlDeEmpresa() {
        agregarDepartamentos();
        listadoDepartamentos();
    }
    
    private void agregarDepartamentos() {
       empresa.agregarDepartamentos();
    }
    
    private void listadoDepartamentos() {
        empresa.listadoDepartamentos();
    }    
}
