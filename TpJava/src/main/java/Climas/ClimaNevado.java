package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NEVADO;

public class ClimaNevado extends Clima{

    public ClimaNevado(){
        this.nombre = CLIMA_NEVADO;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
