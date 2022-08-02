package Clase07_07.cuarto;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        TxtAnalyzer myAnalyzer = new TxtAnalyzer();
        
        System.out.println("Bienvenido, vamos a verificar algunas caracteristicas del archivo corizacion_5.txt");
        System.out.println("Ingrese la accion que desea realizar");
        
        System.out.println("""
                           1) Calcular numero de palabras.
                           2) Calcular numero de lineas.
                           3) Calcular el numero de veces que aparece una palabra.
                           4) Calcular el numero de palabras que empiezan con una letra.
                           5) Calcular el numero de veces que aparece una letra.
                           """);
        
        Scanner sc = new Scanner(System.in);
        int opcion = Integer.parseInt(sc.next());
        
        switch(opcion) {
            case 1 -> {
                System.out.println("El numero de palabras es de " + myAnalyzer.getWordsNumber());
            } case 2 -> {
                System.out.println("El numero de lineas es de " + myAnalyzer.getLinesNumber());
            } case 3 -> {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce la palabra:");
                String word = scanner.next();
                
                System.out.println("El numero de veces que se repite la palabra es de "
                        + myAnalyzer.calculateSpecificWord(word));
            } case 4 -> {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce la letra:");
                char letter = scanner.next().charAt(0);
                
                System.out.println("El numero de veces que aparece la letra al comienzo de las palabras es de "
                        + myAnalyzer.calculateWordWithSpecificFirstLetter(letter));               
            } case 5 -> {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce la letra:");
                char letter = scanner.next().charAt(0);
                
                System.out.println("El numero de veces que aparece la letra es de "
                        + myAnalyzer.calculateSpecificLetter(letter));                               
            } default -> System.out.println("No has ingresado una opcion valida");                              
        }                                     
    }   
}
