package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_HURACAN;

public class ClimaHuracan extends Clima{

    public ClimaHuracan(){
        this.nombre = CLIMA_HURACAN;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
