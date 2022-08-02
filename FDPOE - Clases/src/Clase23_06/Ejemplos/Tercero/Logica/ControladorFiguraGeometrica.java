package Clase23_06.Ejemplos.Tercero.Logica;

import java.util.ArrayList;


public class ControladorFiguraGeometrica {   
    ArrayList<FiguraGeometrica> listadoFiguras ;
    
    public ControladorFiguraGeometrica() {
        listadoFiguras = new ArrayList();
    }
    
    public void controladorDeObjetos() {
        crearColeccion();
        calcularAreas();
        imprimirFiguras();
    }
    
    public void crearColeccion() {               
        Circulo circulo = new Circulo(5, "Circulo");
        Triangulo triangulo = new Triangulo(5, 4, "Triangulo");
        Rectangulo rectangulo = new Rectangulo(6, 3, "Rectangulo");
        
        listadoFiguras.add(circulo);
        listadoFiguras.add(triangulo);
        listadoFiguras.add(rectangulo);
        listadoFiguras.add(new Circulo(9, "Circulo"));
        listadoFiguras.add(new Triangulo(3, 6, "Tringulo"));
        listadoFiguras.add(new Rectangulo(8, 4, "Rectangulo"));
    }
    
    private void calcularAreas() {
        for(FiguraGeometrica figura : listadoFiguras){
            figura.calcularArea();
        }
    }
    
    private void imprimirFiguras() {        
        listadoFiguras.forEach((figura) -> {
            figura.imprimirDetalles();
            System.out.println("");
        });        
    }
}
