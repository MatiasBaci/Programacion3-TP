package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoEnvenenado extends Estado{

    public EstadoEnvenenado(){
        this.nombre = ESTADO_ENVENENADO;
    }
    

    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon) {
        System.out.println("El Pokemon " + unPokemon.getNombre() + " esta Envenenado.");
        unPokemon.recibirDanio(unPokemon.getVidaMaxima() * PORCENTAJE_VENENO);
    }
}
