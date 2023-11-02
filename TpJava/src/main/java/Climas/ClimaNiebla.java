package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NIEBLA;

public class ClimaNiebla extends Clima{

    public ClimaNiebla(){
        this.nombre = CLIMA_NIEBLA;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
