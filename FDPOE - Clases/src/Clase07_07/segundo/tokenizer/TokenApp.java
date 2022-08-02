package Clase07_07.segundo.tokenizer;

import java.io.IOException;
import java.util.StringTokenizer;

public class TokenApp { 
    StringTokenizer tokens;
    
    public void pruebaTexto(){
        System.out.println("------------Texto con delimitador por defecto-----------------------");
        String name = "Luis Yovany Romo";
	tokens = new StringTokenizer(name); // Por defecto es un " "
        
        while(tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken()); // Tiene un iterador que avanza en cada next
        }
    }
    
    public void pruebaDelimita() {
        System.out.println("------------------ Delimitadores---------------------------");
        String data = "6.3, 6.2, 6.4, 6.2";
        tokens = new StringTokenizer(data, ",");
        int dataNumber = tokens.countTokens(); // Contaria 4
        System.out.println("Cantidad de Tokens en el String: " + dataNumber);

        // Si quiero puedo almacenarlos en un array, pero solo voy a mostrarlos        
        for(int i = 0; i < dataNumber; i++) {
            String aData = tokens.nextToken();
            System.out.println(aData);
        }   
    }

    public void variosDelimita() {       
        System.out.println("-------------Varios Delimitadores---------------------------");
        
        String data = "1=6.3\n2=6.2\n3=6.4\n4=6.2";
        tokens = new StringTokenizer(data, "=\n");
        
        int dataNumber = tokens.countTokens();
        System.out.println("Cantidad: " + dataNumber);
        
        String output = "Datos en una matriz\n"; // 2 x 2 (identificador y numero)
        double[][] datos = new double[dataNumber / 2][dataNumber / 2];
        
        for (int i = 0; i < dataNumber / 2; i++) {
            for (int j = 0; j < 2; j++) {
                datos[i][j] = Double.parseDouble(tokens.nextToken());
                output += datos[i][j] + "\t";
            }
            output += "\n";
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        TokenApp obt = new TokenApp();
        obt.pruebaTexto();
        obt.pruebaDelimita();
        obt.variosDelimita();
	    
        try {
            // Termina cuando el usuario introduce un caracter
            System.in.read();
        } catch(IOException e) {  
            System.out.println("Ha ocurrido un error");
        }
    }
}
