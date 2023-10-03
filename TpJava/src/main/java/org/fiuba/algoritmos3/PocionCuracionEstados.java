package org.fiuba.algoritmos3;

import java.util.Objects;

public class PocionCuracionEstados extends Item{
    public PocionCuracionEstados(String nombre, int cantidad){
        super(nombre, cantidad);
    }
    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        if (!Objects.equals(unPokemon.suEstadoEs(), "Normal") && unPokemon.estaConciente()) {
            unPokemon.cambiarseEstado(new EstadoNormal("Normal"));
            return realizarUsadoItemsDeEstado(unPokemon.getEstadoActual());
        } else {
            System.out.println(" ");
            System.out.println("No se puede aplicar este item a un Pokemon Inhabilitado o Normal.");
            return false;
        }
    }

    public void mostrarItem() {
        System.out.println(nombre + ": Elimina los Estado del pokemon - Cantidad: " + cantidad);
    }
}
