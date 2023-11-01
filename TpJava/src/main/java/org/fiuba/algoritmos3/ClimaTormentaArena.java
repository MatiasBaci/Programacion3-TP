package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_TORMENTA_DE_ARENA;

public class ClimaTormentaArena extends Clima{

    public ClimaTormentaArena(){
        this.nombre = CLIMA_TORMENTA_DE_ARENA;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
