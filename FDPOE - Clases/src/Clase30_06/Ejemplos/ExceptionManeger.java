package Clase30_06.Ejemplos;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ExceptionManeger {
    
    public static double division(int x, int y) throws ArithmeticException {
        return x / y;       
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        
        do {
            try {
                System.out.print( "Numerador: " );
                int numerador= scanner.nextInt();             
                System.out.print( "Denominador: " );
                int denominador= scanner.nextInt();
                double divi= division(numerador, denominador);
                System.out.println("Division: " + divi);
                continueLoop = false;
           } catch(InputMismatchException ep) {
                scanner.nextLine(); 
                System.out.println("Usted debe ingresar números enteros.\n");
           } catch(ArithmeticException arithmeticException) {
                System.err.printf("\nException: %s\n", arithmeticException);
                System.out.println("No se puede dividir por cero.\n");
           }
        } while(continueLoop);
    }              
}
