package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_SOLEADO;

public class ClimaSoleado extends Clima{

    public ClimaSoleado(){
        this.nombre = CLIMA_SOLEADO;
    }

    @Override
    protected void aplicarEfectoClima(Pokemon pokemon){

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}

