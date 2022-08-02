package Clase07_07.tercero.modelo;

import java.io.*;
import java.util.StringTokenizer;

public class Archivo implements  Serializable {
    public static final long serialVersionUID = 1L;
    private File archivo;
    private int cantidadPalabras;

    public Archivo(File archivo) {
        this.archivo = archivo;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public int getCantidadPalabras() {
        return cantidadPalabras;
    }

    public void setCantidadPalabras(int cantidadPalabras) {
        this.cantidadPalabras = cantidadPalabras;
    }
    
    public void contarPalabras() throws IOException {
        int palabras = 0;
        FileReader fileReader = new FileReader(getArchivo());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;
        
        while((linea = bufferedReader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(linea, " "); // Una palabra esta separada por un 
            // espacio
            int total = st.countTokens();
            palabras += total;
        }   
        setCantidadPalabras(palabras);
    }
}
