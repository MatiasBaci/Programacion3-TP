package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_HURACAN;

public class ClimaHuracan extends Clima{

    public ClimaHuracan(){
        this.nombre = CLIMA_HURACAN;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
        if(pokemon.getTipo().verSiEsAbrasivo(this.nombre)){
            pokemon.getCualidades().recibirDanio(pokemon.getCualidades().getVidaMaxima() * 0.03);
        }
    }
}
