package logica;

/**
 *
 * @author Yovany Romo
 */

public class Ronda {
    private static int totalRondas;
    private int numeroAdivinar;
    private int intentosRonda;
    private int numeroRonda;

    public Ronda() {
        ++totalRondas;
        setNumeroRonda(totalRondas);
        generarNumeroAdivinar();
        intentosRonda = 0;
    }

    private void generarNumeroAdivinar() {
        int numero = (int)(1 + Math.random() * 100);
        setNumeroAdivinar(numero);
    }

    public boolean esElNumero(int numero) {
        intentosRonda++;
        return(numeroAdivinar == numero);
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getIntentosRonda() {
        return intentosRonda;
    }

    public void setIntentosRonda(int intentosRonda) {
        this.intentosRonda = intentosRonda;
    }
}
