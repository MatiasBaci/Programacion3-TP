package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoInhabilitado extends Estado{

    public EstadoInhabilitado(){
        this.nombre = ESTADO_INHABILITADO;
        this.color = ANSI_FONDO_ROJO + ANSI_BLANCO;
    }
    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return false;
    }
    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
        System.out.println("El pokemon actual esta inhabilitado.");
    }
}
