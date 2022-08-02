package Clase23_06.Ejemplos.Cuarto;

import javax.swing.JOptionPane;

/**
 * clase que invoca  a través de un menú la utilización de algunas de las colecciones en Java
 * @author LeovivianaM
 */
public class EjemploColecciones {   
    Articulo a1,a2,a3,a4,a5;
    ClaseVector ejVector;
    ClaseArrayList ejArrayList;
    ClaseSet ejSet;
    ClaseQueue ejQueue;    
    
    /**
     * Constructor de la clase, donde se inicializan los objetos artículos y 
     * las diferentes coleccions de Java
     * 
     */
    
    public EjemploColecciones() {
         a1 = new Articulo("1234", 55000);
         a2 = new Articulo("2345", 65000);
         a3 = new Articulo("3456", 89000);
         a4 = new Articulo("4567", 41000);
         a5 = new Articulo("5678", 37000);  
         
         ejVector = new ClaseVector();
         ejArrayList = new ClaseArrayList();
         ejSet = new ClaseSet();
         ejQueue = new ClaseQueue();
    }
           
    /**
     * Menú donde se invoca a los métodos correspondetes decada clase según la opción seeccionada por el usuario
     */
    public void menu() {
        int op;
        
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("***** ---- EJEMPLOS COLECCIONES EN JAVA ---- *****\n\n"
                    + "*** VECTOR (Lista) ***"
                    + "\n 1  - Insertar datos en Vector"
                    + "\n 2  - Mostrar datos del Vector"
                    + "\n\n*** ARRAYLIST (lista) ***"
                    + "\n 3  - Insertar datos en ArrayList"
                    + "\n 4  - Mostrar datos del ArrayList"
                    + "\n 5  - Ordenar y mostrar los datos de la lista por precio"
                    + "\n\n *** HASHSET (conjuntos) ***" 
                    + "\n 6  - Insertar datos en Conjunto" 
                    + "\n 7  - Mostrar datos del Conjunto"
                    + "\n\n *** QUEUE (Colas) ***" 
                    + "\n 8  - Insertar datos en Cola" 
                    + "\n 9  - Mostrar datos de la cola"
                    + "\n 10 - Eliminar Cabeza de la cola"
                    + "\n 11 - Mostrar Cabeza de la cola"
                    + "\n\n 12 - SALIR")); // Si lo deja vacio op va ser una cadena vacia                       
            switch(op) {
                case 1 -> {
                    ejVector.insertarArticulos(a1);
                    ejVector.insertarArticulos(a2);
                    ejVector.insertarArticulos(a3);
                    ejVector.insertarArticulos(a4);
                    ejVector.insertarArticulos(a5);
                    JOptionPane.showMessageDialog(null, "********* VECTOR ***********\n"
                            + "Se adicionaron artículos al vector con éxito!");
                }
                            
                case 2 -> ejVector.imprimirArticulo();
                            
                case 3 -> {
                    ejArrayList.insertarArticulos(a1);
                    ejArrayList.insertarArticulos(a2);
                    ejArrayList.insertarArticulos(a3);
                    ejArrayList.insertarArticulos(a4);
                    ejArrayList.insertarArticulos(a5);
                    JOptionPane.showMessageDialog(null, "********* ARRAYLIST ***********\n"
                            + "Se adicionaron artículos al arrayList con éxito!");
                }
                            
                case 4 -> ejArrayList.imprimirArticulo();
                            
                case 5 -> ejArrayList.ordenarClecconPorPrecio();  
                            
                case 6 -> {
                    ejSet.insertarArticulos(a1);
                    ejSet.insertarArticulos(a2);
                    ejSet.insertarArticulos(a3);
                    ejSet.insertarArticulos(a4);
                    ejSet.insertarArticulos(a5);
                    ejSet.insertarArticulos(a2);
                    ejSet.insertarArticulos(a1);
                    JOptionPane.showMessageDialog(null, "********* SET ***********\n"
                            + "Se adicionaron artículos al HashSet con éxito!");
                }
                            
                case 7 -> ejSet.imprimirArticulo();
                            
                case 8 -> {
                    ejQueue.adicionarACola(a1);
                    ejQueue.adicionarACola(a2);
                    ejQueue.adicionarACola(a3);
                    ejQueue.adicionarACola(a4);
                    ejQueue.adicionarACola(a5);
                    JOptionPane.showMessageDialog(null, "********* QUEUE ***********\n"
                            + "Se adicionaron artículos a la cola con éxito!");
                }
                            
                case 9 -> ejQueue.imprimirDatosCola();
                            
                case 10 -> ejQueue.eliminar();
                            
                case 11 -> ejQueue.verCabezaDeCola();         
            }
            
        } while(op != 12);   
        System.exit(0);
    }
       
    /**
     * Método principal por donde inicia la aplicación
     * @param args 
     */
    public static void main(String[] args) {
        EjemploColecciones app = new EjemploColecciones();
        
        app.menu();    
    }
}
