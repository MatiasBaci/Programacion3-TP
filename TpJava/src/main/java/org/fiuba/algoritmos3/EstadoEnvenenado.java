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
        unPokemon.recibirDanio(unPokemon.getVidaMaxima()*0.5);
    }
}
