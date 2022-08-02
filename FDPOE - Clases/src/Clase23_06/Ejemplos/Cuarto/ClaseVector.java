package Clase23_06.Ejemplos.Cuarto;

import java.util.Vector;
import javax.swing.JOptionPane;


/**
 * Creación de un Vector, inserción e impresión de datos
 * @author LeovivianaM
 */
public class ClaseVector {   
    Vector<Articulo> vectorDeArticulos;
    
    /**
     * Constructor de la clase, en el que se crea la colección de la clase Vector
     */
    public ClaseVector() {
        vectorDeArticulos = new Vector<>();
        
    }
       
    /**
     * Método que inserta artículos al vector
     * @param art : el artículo que se va a adicionar
     */
    public void insertarArticulos(Articulo art) {              
        vectorDeArticulos.addElement(art);          
    }
    
    /**
     * Método que imprime los elementos almacenados en el vector
     */
    public void imprimirArticulo() {
        String articulos = "Los artículos del Vector son: \n";
        for (int i = 0; i < vectorDeArticulos.size(); i++) {
            articulos += vectorDeArticulos.get(i).getInfoArticulo() + "\n";            
        }
        JOptionPane.showMessageDialog(null, "********* CLASE VECTOR ***********" + articulos);
    }  
}
