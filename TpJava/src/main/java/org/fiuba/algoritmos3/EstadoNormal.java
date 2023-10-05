package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoNormal extends Estado{

    public EstadoNormal(){
        this.nombre = ESTADO_NORMAL;
    }

    @Override
    public boolean puedeAtacar(Pokemon unPokemon){
        return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
    }
}
