package org.fiuba.algoritmos3;

public class Lanzallamas extends Habilidad{
    public Lanzallamas(String nombre,int cantidadUsos){
        super(nombre,cantidadUsos);
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo, Pokemon unPokemonPropio) {
        this.cantidadDeUsos -= 1;
        unPokemonEnemigo.modificarEstadisticas("Defensa",2);
    }

    @Override
    public void mostrarHabilidad() {

    }
}
