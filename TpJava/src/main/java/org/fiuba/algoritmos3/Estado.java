package org.fiuba.algoritmos3;

public abstract class Estado { // debería ser una interfaz probalbemente


    protected String nombre;


    public Estado(String nombre){
        this.nombre = nombre;
    }


    public abstract void efectoActivo(Pokemon unPokemon);

    public abstract void efectoPasivo(Pokemon unPokemon);


    public String getNombre() {
        return nombre;
    }

}
