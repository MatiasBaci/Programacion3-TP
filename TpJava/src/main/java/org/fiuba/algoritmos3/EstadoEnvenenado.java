package org.fiuba.algoritmos3;

public class EstadoEnvenenado extends Estado{

    public EstadoEnvenenado(String nombre){
        super(nombre);
    }

    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon) {
        unPokemon.recibirDanio(unPokemon.obtenerVidaMaxima()*0.5);
    }
}
