package Clase30_06.Ejemplos;


public class ExceptionContinua {   
    public static void divide() {        
       int[] num = {4, 8, 16, 32, 64, 128, 256};
       int[] den = {2, 0, 4, 4, 0, 8, 16};
       
       for (int i = 0; i < num.length; i++) {
            try { 
                System.out.println(num[i] + "/" + "=" + num[i] / den[i]);
            } catch(ArithmeticException excepcion) {
                System.out.println("Error... Dividiendo por cero");
            }
       }
    }
    
     public static void divide2() throws ArithmeticException{        
       int[] num = {4, 8, 16, 32, 64, 128, 256};
       int[] den = {2, 0, 4, 4, 0, 8, 16};
       
        for (int i = 0; i < num.length; i++){
            System.out.println(num[i]+ "/" + den[i] + "=" + num[i] / den[i]);
       }
    }

    public static void main(String args[]){
        divide();              
        try { 
            divide2();
        } catch(ArithmeticException excepcion) {
            System.out.println("Error... Dividiendo por cero lanzada desde throws");
        }
        System.out.println("Continua...");        
    }     
}


