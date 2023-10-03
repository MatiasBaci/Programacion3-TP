package org.fiuba.algoritmos3;

public class EstadoNormal extends Estado{

    public EstadoNormal(String nombre){
        super(nombre);
    }

    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
    }
}
