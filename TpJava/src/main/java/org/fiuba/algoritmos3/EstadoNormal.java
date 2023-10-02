package org.fiuba.algoritmos3;

public class EstadoNormal extends Estado{

    public EstadoNormal(String nombre){
        super(nombre);
    }


    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }
    

    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
    }
}
