package Clase30_06.Ejemplos;


public class ArrayException {
    double notas[] =  new double[10];
    
    public void setNotas() {       
        for (int i = 0; i<= notas.length; i++){
            notas[i] = Math.round(Math.random() * 10);
        }
    }
    
    public static void main (String[] args) {       
        ArrayException ar =  new ArrayException();
        ar.setNotas();       
    }
}
