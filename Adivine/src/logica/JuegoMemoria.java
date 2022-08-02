package logica;

import modelo.Jugador;

/**
 *
 * @author Yovany Romo
 */

public class JuegoMemoria {
    private Jugador jugador;
    private Ronda mejorRonda;
    private Ronda ronda;
    
    public JuegoMemoria(Jugador jugador) {
        this.jugador = jugador;              
    }

    public void iniciarRonda(){
        ronda = new Ronda();
        if (ronda.getNumeroRonda() == 1) {
            mejorRonda = ronda;
        }
    }

    public boolean esElNumero(int numero) {
        return ronda.esElNumero(numero);            
    }

    public String getJugador() {
        return jugador.getNombre();
    }

    public int getNumeroRonda() {
        return ronda.getNumeroRonda();
    }

    public int getIntentosRonda() {
        return ronda.getIntentosRonda();
    }

    public int getNumeroAdivinar() {
        return ronda.getNumeroAdivinar();
    }

    public Ronda getMejorRonda() {
        return mejorRonda;
    }

    public void compararRondas() {
        if(ronda.getIntentosRonda() < mejorRonda.getIntentosRonda()){
            mejorRonda = ronda;
        }
    }
}
