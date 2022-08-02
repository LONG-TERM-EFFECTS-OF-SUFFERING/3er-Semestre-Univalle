package Clase30_06.Ejemplos;


public class VentaCasa {
    private Casa casa;

    public static void main(String[] args) {
        VentaCasa vender = new VentaCasa();
        System.out.println(vender.casa.getPrecio()); // Como el precio de la casa no se inicializa, estamos
        // aplicandole un metodo a un objeto "null"
    }   
}


