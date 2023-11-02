package Estados;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoParalizado extends Estado{

    private int numeroRandom;
    public EstadoParalizado() {
        this.nombre = ESTADO_PARALIZADO;
        this.color = ANSI_FONDO_AMARILLO + ANSI_NEGRO;
    }

    public int getNumeroRandom() {
        return numeroRandom;
    }

    @Override
    public boolean puedeAtacar() {
        
        Random newRandom = new Random();
        //set a new random between 1 and 100
        this.numeroRandom = newRandom.nextInt(100)+1;
        
        if(this.numeroRandom <= 50) {
            return false;
        }
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado() {
    }
}
