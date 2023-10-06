package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Objects;

public class HabilidadEstado extends Habilidad{

    private final Estado unEstado;
    public HabilidadEstado(String nombre, int cantidad,Estado unEstado) {
        super(nombre, cantidad);
        this.unEstado = unEstado;
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo, Pokemon unPokemonPropio) {
        this.cantidadDeUsos --;
        if (Objects.equals(unPokemonEnemigo.suEstadoEs(), ESTADO_NORMAL)) {
            unPokemonEnemigo.cambiarseEstado(this.unEstado);
            this.mostrarUso(unPokemonEnemigo, unPokemonPropio);
        }
        else {
            System.out.println(this.nombre + " no tuvo efecto porque el pokemon enemigo ya se encuentra " + unPokemonEnemigo.suEstadoEs() + ".");
        }
    }

    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Estado: " + this.unEstado.getNombreConColor());
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }

    @Override
    public void mostrarUso(Pokemon unPokemonEnemigo,Pokemon unPokemon){
        System.out.println("¡"+ unPokemon.getNombre() + " uso " + this.nombre + "!");
        System.out.println(unPokemonEnemigo.getNombre() + " esta " + unEstado.getNombre());
    }
}
