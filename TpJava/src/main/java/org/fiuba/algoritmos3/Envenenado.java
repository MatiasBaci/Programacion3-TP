package org.fiuba.algoritmos3;

public class Envenenado extends Estado{
    @Override
    public void efecto(Pokemon unPokemon) {
        double danio = (double)(0.05*unPokemon.obtenerVidaMaxima());
        unPokemon.recibirDanio(danio);
        //int danio = (int)(0.05* unaEstadistica.getVidaMaxima());
        //unaEstadistica.reduccionVida(danio);
    }
}
