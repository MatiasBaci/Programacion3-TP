package org.fiuba.algoritmos3;

public class EstadoInhabilitado extends Estado{

    public EstadoInhabilitado(String nombre){
        super(nombre);
    }
    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return false;
    }
    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
        System.out.println("El pokemon actual esta inhabilitado.");
    }
}
