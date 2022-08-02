package Clase23_06.Ejemplos.Segundo.Empresa;

import Clase23_06.Ejemplos.Segundo.Logica.*;


public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorEmpresa empresa = new ControladorEmpresa(new Empresa("Univalle", "80234567"));
        empresa.controlDeEmpresa();
    }  
}
