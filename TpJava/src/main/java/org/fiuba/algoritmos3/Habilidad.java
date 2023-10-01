package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Habilidad {

    public String getNombre() { //Porque no lo toma la hija
        return nombre;
    }

    protected String nombre;
    protected int cantidadDeUsos;
    

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    public abstract void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio);

    public abstract void mostrarHabilidad();
}
