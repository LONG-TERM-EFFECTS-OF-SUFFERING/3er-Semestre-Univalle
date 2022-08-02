package Clase30_06.Ejemplos;


public class NullPointerExceptionExample {   
    public static void main(String[] args) {	        
	String cadenaPrueba = null;
                
	try {
            if (cadenaPrueba.equals("")) {
                System.out.println("Cadena es vacia");
            } else {
                System.out.println("Cadena no vacia");
            }                  
	} catch(NullPointerException ex) {           
	        System.out.println("Una excepción: " + ex);
	    }
    }
}

