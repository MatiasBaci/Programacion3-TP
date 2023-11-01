package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_LLUVIA;

public class ClimaLLuvia extends Clima{

    public ClimaLLuvia(){
        this.nombre = CLIMA_LLUVIA;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon){

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
