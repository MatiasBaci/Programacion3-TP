package org.fiuba.algoritmos3;

import java.util.Objects;

public class PocionCuracionEstados extends Item{

    public PocionCuracionEstados(String nombre, int cantidad){
        super(nombre, cantidad);
    }
    @Override
    public void aplicarItem(Pokemon unPokemon) {

        if (!Objects.equals(unPokemon.suEstadoEs(), "Normal") && !unPokemon.estaVivo()) {
            unPokemon.cambiarseEstado(new EstadoNormal("Normal"));
            this.cantidad --;
            itemUsado = true;

        } else {
            System.out.println(" ");
            System.out.println("No hay estado que curar.");
        }
    }

    public void mostrarItem() {
        System.out.println(nombre + ": Elimina los Estado del pokemon - Cantidad: " + cantidad);
    }
}
