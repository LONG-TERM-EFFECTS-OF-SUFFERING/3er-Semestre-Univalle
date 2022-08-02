package Clase23_06.Ejemplos.Cuarto;

import java.util.Comparator;


/**
 * clase con el uso de la interfaz Comparator, para ordenar los elementos
 * de la colección que contenga  estos objetos, por el atributo de precio
 * @author invitado
 */
public class ComparadorArticulo implements Comparator<Articulo> {
        
   /**
    * Este método pertenece a la interfaz Comparator, y nos sirve para orderna
    * los elementos de tipo Articulo que e encuentren almacenados en una colección 
    * por cualquiera de los atributos del artículo.  se va a hacer por el precio de menor a mayor
    * @param o1
    * @param o2
    * @return   
    * retorna un entero positivo si el precio de primer objeto es mayor que el edl o2
    * retorna 0 si los dos dats son iguales
    * retorna un entero negativo si el primer precio es menor que el segundo   
    */
  
    @Override
    public int compare(Articulo o1, Articulo o2) {
        return (int) (o1.getPrecio() - o2.getPrecio());
    }  
}
