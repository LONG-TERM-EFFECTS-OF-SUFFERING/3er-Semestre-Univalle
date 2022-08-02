package Clase07_07.cuarto;

import java.io.*;
import java.util.StringTokenizer;

public class TxtAnalyzer {
    private int wordsNumber;
    private int linesNumber;    
    private StringTokenizer stringToken;   
    private File txt;
    private String line;
    
    public TxtAnalyzer() {
        try {
            txt = new File("src/Clase07_07/cuarto/cotizacion_5.txt");
            
        } catch(Exception e) {
            System.out.println("Error, archivo no encontrado");
        }
        linesNumber = 0;
        wordsNumber = 0;
    }
       
    public int getWordsNumber() throws IOException{
        FileReader fileReader = new FileReader(txt);
        BufferedReader bufferedReader = new BufferedReader(fileReader);       
        
        while((line = bufferedReader.readLine()) != null) {
            stringToken = new StringTokenizer(line, " ");
            
            int total = stringToken.countTokens();
            wordsNumber += total;
        } 
        return wordsNumber;
    }
    
    public int getLinesNumber() throws FileNotFoundException, IOException{
        FileReader fileReader = new FileReader(txt);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while((line = bufferedReader.readLine()) != null) {
            linesNumber += 1;
        }
        return linesNumber;
    }
       
    public int calculateSpecificWord(String word) throws FileNotFoundException, IOException{
        FileReader fileReader = new FileReader(txt);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        int total = 0;
        
        while((line = bufferedReader.readLine()) != null) {
            stringToken = new StringTokenizer(line, " ");
            
            while(stringToken.hasMoreTokens()) {
                if(word.equals(stringToken.nextToken())) {
                    total += 1;
                }
            }
        }
        return total;
    }
    
    public int calculateWordWithSpecificFirstLetter(char letter) throws FileNotFoundException, IOException { // Por la que comienza
        FileReader fileReader = new FileReader(txt);
        BufferedReader bufferedReader = new BufferedReader(fileReader);       
        int total = 0;
        
        while((line = bufferedReader.readLine()) != null) { 
            stringToken = new StringTokenizer(line, " ");
            
            while(stringToken.hasMoreTokens()) {
                char firstLetter = stringToken.nextToken().charAt(0);
                
                if(letter == firstLetter) {
                    total += 1;
                }
            }   
        }
        return total;
    }   
    
    public int calculateSpecificLetter(char letter) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(txt);
        BufferedReader bufferedReader = new BufferedReader(fileReader);       
        int total = 0;
        
        while((line = bufferedReader.readLine()) != null) {
            char[] charsLine = line.toCharArray(); // Convertimos line en una lista de chars

            for(int i = 0; i < charsLine.length; i++) {
                if(charsLine[i] == letter) {
                    total += 1;
                }
            }               
        }      
        return total;
    }
}
