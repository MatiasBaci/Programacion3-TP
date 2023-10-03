package org.fiuba.algoritmos3;

public abstract class Habilidad {

    protected String nombre;

    protected int cantidadDeUsos;

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    public String getNombre() { //Porque no lo toma la hija
        return this.nombre;
    }

    public abstract void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio);

    public abstract void mostrarHabilidad();
}
