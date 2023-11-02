package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NORMAL;

public class ClimaNormal extends Clima{

    public ClimaNormal(){
        this.nombre = CLIMA_NORMAL;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
