package Clase30_06.Ejemplos;


public class ExcepcionesMultiples {   
    static void divide() {
        
       int num[] = {4, 8, 16, 32, 64, 128, 256};
       int den[] = {2 , 0, 4, 4, 0, 8};
       
       for (int i = 0; i < num.length + 1; i++) {
            try {
                System.out.println(num[i]+ "/" + "=" + num[i] / den[i]);
            } catch(ArithmeticException e) {
                System.out.println("Excepción dividiendo por cero");
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Excepción  al acceder al arreglo");
            } catch(Exception e) {
                System.out.println ("Captura cualquier excepción");
            }
      }                                                                     
   }
    
    public static void main(String args[]) {
        ExcepcionesMultiples.divide();
            
        System.out.println("Finalizando ...");
    }
}
