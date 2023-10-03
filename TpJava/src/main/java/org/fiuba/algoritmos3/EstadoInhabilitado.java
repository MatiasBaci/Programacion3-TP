package org.fiuba.algoritmos3;

public class EstadoInhabilitado extends Estado{

    public EstadoInhabilitado(String nombre){
        super(nombre);
    }

    public boolean puedeAtacar(Pokemon unPokemon){
        return false;
    }

    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
        System.out.println("El pokemon actual esta inhabilitado.");

    }
}
