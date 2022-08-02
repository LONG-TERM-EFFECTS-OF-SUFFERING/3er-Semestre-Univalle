package Clase23_06.Ejemplos.Cuarto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;


/**
 * Creación de una Cola, inserción e impresión de datos
 * @author LeovivianaM
 */
public class ClaseQueue {   
    Queue<Articulo> cola;
               
    /**
     * Constructor de la claseQueue
     */
    public ClaseQueue() {
        cola = new LinkedList<>();
    } 
  
    /**
     * Adiconar elementos a la cola, siempre los coloca al final
     * @param art 
     */
    public void adicionarACola(Articulo art) {
        cola.add(art);    
    }
    
    /**
     * Imprimr los elemetos almacenados en una cola
     */
    public void imprimirDatosCola() {
        String articulos = "Los artículos de la cola son: \n";
        Iterator iterador = cola.iterator();
        while(iterador.hasNext()) {
            articulos += ((Articulo) iterador.next()).getInfoArticulo() + "\n";     
        }
        JOptionPane.showMessageDialog(null, "********* CLASE QUEUE ***********" + articulos);      
    }
  
    /**
     * Eliminar el elemento que estade primero (en la cabeza) de la cola
     */
    public void eliminar() {               
        JOptionPane.showMessageDialog(null, """
                                            ********* CLASE QUEUE ***********
                                            Se elimin\u00f3 la cabeza de la cola ,el elemento """ + ((Articulo) cola.remove()).getInfoArticulo());
        // El metodo remove ademas de remover el primer elemento de la cola, lo retorna
        imprimirDatosCola();       
    }
     
 
    /***
     * Muestra el elemento que está en a cabeza de la coa sin eiminaro
     */
    public void verCabezaDeCola()
    {
        //muestra la cabeza de la cola, sin eliminarla
         JOptionPane.showMessageDialog(null, """
                                             ********* CLASE QUEUE ***********
                                             Se elimin\u00f3 la cabeza de la cola ,el elemento """ + ((Articulo) cola.peek()).getInfoArticulo());        
    }     
}
