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
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio) {
        this.cantidadDeUsos --;
        if (Objects.equals(cualidadesPokemonEnemigo.suEstadoEs(), ESTADO_NORMAL)) {
            cualidadesPokemonEnemigo.cambiarseEstado(this.unEstado);
        }
        else {
            System.out.println(this.nombre + " no tuvo efecto porque el pokemon enemigo ya se encuentra " + cualidadesPokemonEnemigo.suEstadoEs() + ".");
        }
    }

    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Estado: " + this.unEstado.getNombreConColor());
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }

}
