package org.fiuba.algoritmos3;

public abstract class   Estado {


    protected String nombre;


    public Estado(String nombre){
        this.nombre = nombre;
    }


    public abstract boolean puedeAtacar(Pokemon unPokemon);

    public abstract void aplicarEfectoPasivoDeEstado(Pokemon unPokemon);


    public String getNombre() {
        return nombre;
    }

}
