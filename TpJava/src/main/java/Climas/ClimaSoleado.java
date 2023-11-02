package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_SOLEADO;

public class ClimaSoleado extends Clima{

    public ClimaSoleado(){
        this.nombre = CLIMA_SOLEADO;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon){

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}

