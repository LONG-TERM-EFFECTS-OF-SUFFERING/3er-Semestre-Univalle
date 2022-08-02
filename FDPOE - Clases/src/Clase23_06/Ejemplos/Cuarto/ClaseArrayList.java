package Clase23_06.Ejemplos.Cuarto;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;


/**
 * Creación de un ArrayList, inserción e impresión de datos
 * @author LeovivianaM
 */
public class ClaseArrayList {
    ArrayList<Articulo> arrayListDeArticulos;
    
    /**
     * Constructor de la clase, en el que se crea la colección de la clase ArrayList
     */
    public ClaseArrayList() {
        arrayListDeArticulos = new ArrayList<>();       
    }
    
    /**
     * Método que inserta artículos al ArrayList
     * @param art : el artículo que se va a adicionar
     */
    public void insertarArticulos(Articulo art) {              
        arrayListDeArticulos.add(art);           
    }
    
    /**
     * Método que imprime los datos que se encuetran almacenads en el arraylist
     */
    public void imprimirArticulo() {
        String articulos = "Los artículos del ArrayList son: \n";
        for (int i = 0; i < arrayListDeArticulos.size(); i++) {
            articulos += arrayListDeArticulos.get(i).getInfoArticulo() + "\n";            
        }
        JOptionPane.showMessageDialog(null, "********* CLASE ARRAYLIST ***********" + articulos);
    }
    
    /**
     * método que ordea los datos qe se encuentran en el arreglo por precio, de menor a mayor
     */
    
    public void ordenarClecconPorPrecio() {
        /**
         * invoca al método sort de la case Collections que va a usar para su orden lo que se especifica en el método compare 
         * de la clase comparadorArticulo
         */
        Collections.sort(arrayListDeArticulos, new ComparadorArticulo());
        imprimirArticulo();  
    }   
}
