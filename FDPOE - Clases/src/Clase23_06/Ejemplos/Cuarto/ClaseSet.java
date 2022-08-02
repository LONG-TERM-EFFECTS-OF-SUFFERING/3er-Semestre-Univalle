package Clase23_06.Ejemplos.Cuarto;

import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 * Creación de un Set, inserción e impresión de datos
 * @author LeovivianaM
 */
public class ClaseSet {
    HashSet<Articulo> setDeArticulos; 
    
    /**
     * Constructor de la clase, en el que se crea la colección de la clase HashSet
     */
    public ClaseSet() {
        setDeArticulos = new HashSet<>();   
    }
       
    /**
     * Método que inserta artículos al HashSet
     * @param art : el artículo que se va a adicionar
     */
    public void insertarArticulos(Articulo art) {              
        setDeArticulos.add(art);          
    }
    
    
    /**
     * Método que imprime los elemnto almacenados en el conjunto
     */
    public void imprimirArticulo() {
        String articulos = "Los artículos del HastSet son: \n";
        
        //se obtiene el iterador para poder recorrer el set
        Iterator iterador = setDeArticulos.iterator();
        
        while(iterador.hasNext()) {
            articulos += ((Articulo) iterador.next()).getInfoArticulo()+ "\n";            
        }
        JOptionPane.showMessageDialog(null, "********* CLASE HASHSET ***********" + articulos);
    }    
}
