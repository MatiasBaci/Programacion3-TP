package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Objects;

public class HabilidadEstado extends Habilidad{

    private Estado unEstado; //Hay que cambiarle el nombre
    public HabilidadEstado(String nombre, int cantidad,Estado unEstado) {
        super(nombre, cantidad);
        this.unEstado = unEstado;
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo, Pokemon unPokemonPropio) {
        // se encarga de que haga el efecto y como tambien que cambie el estado del pokemon enemigo
        this.cantidadDeUsos --;

        if (Objects.equals(unPokemonEnemigo.suEstadoEs(), ESTADO_NORMAL)) {
            unPokemonEnemigo.cambiarseEstado(this.unEstado);
            mostrarUso(unPokemonEnemigo, unPokemonPropio);
        } 

        else {
            System.out.println(this.nombre + " no tuvo efecto porque el pokemon enemigo ya se encuentra " + unPokemonEnemigo.suEstadoEs() + ".");
        }
    }

    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Estado: " + this.unEstado.getNombre());
        System.out.println("Cuantas Etapas: " + 5);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }

    public void mostrarUso(Pokemon unPokemonEnemigo,Pokemon unPokemon){
        System.out.println("¡"+ unPokemon.getNombre() + " uso " + this.nombre + "!");
        System.out.println(unPokemonEnemigo.getNombre() + " esta " + unEstado.getNombre());
    }
}
