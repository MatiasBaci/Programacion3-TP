package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoInhabilitado extends Estado{

    public EstadoInhabilitado(){
        this.nombre = ESTADO_INHABILITADO;
    }
    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return false;
    }
    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
        System.out.println("El Pokemon " + unPokemon.getNombre() + " esta inhabilitado.");
        System.out.println("Seleccione otro Pokemon: ");
        System.out.println("\n");
    }
}
