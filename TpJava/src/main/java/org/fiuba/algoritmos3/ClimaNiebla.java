package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NIEBLA;

public class ClimaNiebla extends Clima{

    public ClimaNiebla(){
        this.nombre = CLIMA_NIEBLA;
    }

    @Override
    protected void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
