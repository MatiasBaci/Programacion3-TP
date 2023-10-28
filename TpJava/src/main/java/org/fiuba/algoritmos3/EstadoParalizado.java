package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoParalizado extends Estado{

    public EstadoParalizado() {
        this.nombre = ESTADO_PARALIZADO;
        this.color = ANSI_FONDO_AMARILLO + ANSI_NEGRO;
    }

    @Override
    public boolean puedeAtacar() {
        
        Random newRandom = new Random();
        //set a new random between 1 and 100
        int random = newRandom.nextInt(100)+1;
        
        if (random <= 50)
        {
            System.out.println("El pokemon está paralizado y no pudo atacar."); //sacarlo
            return false;
        }
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado() {
    }
}
