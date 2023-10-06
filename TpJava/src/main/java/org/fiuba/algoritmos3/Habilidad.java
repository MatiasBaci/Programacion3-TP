package org.fiuba.algoritmos3;

public abstract class Habilidad {

    protected final String nombre;

    protected int cantidadDeUsos;

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio);

    public abstract void mostrarHabilidad();

    public abstract void mostrarUso(Pokemon unPokemonEnemigo,Pokemon unPokemon);
}
