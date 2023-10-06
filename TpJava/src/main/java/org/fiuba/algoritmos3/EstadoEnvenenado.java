package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoEnvenenado extends Estado{

    public EstadoEnvenenado(){
        this.nombre = ESTADO_ENVENENADO;
        this.color = ANSI_FONDO_VIOLETA + ANSI_BLANCO;
    }
    

    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon) {
        unPokemon.recibirDanio(unPokemon.getVidaMaxima() * PORCENTAJE_VENENO);
    }
}
