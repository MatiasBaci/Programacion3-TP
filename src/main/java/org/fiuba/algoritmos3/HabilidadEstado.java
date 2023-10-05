package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Objects;

public class HabilidadEstado extends Habilidad{

    private Estado unEstado;
    public HabilidadEstado(String nombre, int cantidad,Estado unEstado) {
        super(nombre, cantidad);
        this.unEstado = unEstado;
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo, Pokemon unPokemonPropio) {
        this.cantidadDeUsos --;

        if (Objects.equals(unPokemonEnemigo.suEstadoEs(), ESTADO_NORMAL)) {
            unPokemonEnemigo.cambiarseEstado(this.unEstado);
            this.mostrarUso(unPokemonEnemigo);
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

    @Override
    public void mostrarUso(Pokemon unPokemon) {
        System.out.println("Se acaba de aplicar la habilidad de estado " + this.nombre + ".");
        System.out.println("El estado actual de " + unPokemon.getNombre() + " es " + this.unEstado.getNombre() + ".");
    }
}
