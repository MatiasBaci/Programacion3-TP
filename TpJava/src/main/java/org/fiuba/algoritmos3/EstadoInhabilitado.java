package org.fiuba.algoritmos3;

public class EstadoInhabilitado extends Estado{

    public EstadoInhabilitado(String nombre, int duracion){
        super(nombre);
    }

    public boolean puedeAtacar(Pokemon unPokemon){
        return false;
    }

    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
    }
}
