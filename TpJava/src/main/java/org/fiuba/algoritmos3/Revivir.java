package org.fiuba.algoritmos3;

import java.util.Objects;

public class Revivir extends Item{

    private Modificacion unaModificacion;

    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public void aplicarItem(Pokemon unPokemon) {
        if(Objects.equals(unPokemon.suEstadoEs(), "Inhabilitado")) {
            double vidaMaxima = unPokemon.getEstadisticas().getVidaMaxima(); //Hay que cambiarlo
            unaModificacion.modificar(unPokemon.getEstadisticas(), (int) vidaMaxima);
            unPokemon.cambiarseEstado(new EstadoNormal("Normal", 1));

        }else{System.out.println("El Pokemon no se puede revivir ya que no esta Inhabilitado");}

    }

    public void mostrarItem() {
        System.out.println("Revivir: Revive al pokemon con toda su salud - Cantidad: " + cantidad);
    }
}
