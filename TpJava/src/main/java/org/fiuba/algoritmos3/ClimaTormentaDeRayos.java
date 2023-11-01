package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.CLIMA_TORMENTA_DE_RAYOS;

public class ClimaTormentaDeRayos extends Clima{

    public ClimaTormentaDeRayos(){
        this.nombre = CLIMA_TORMENTA_DE_RAYOS;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
