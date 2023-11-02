package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_TORMENTA_DE_NIEVE;

public class ClimaTormentaNevada extends Clima{

    public ClimaTormentaNevada(){
        this.nombre = CLIMA_TORMENTA_DE_NIEVE;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
        if(pokemon.getTipo().verSiEsAbrasivo(this.nombre)){
            pokemon.getCualidades().recibirDanio(pokemon.getCualidades().getVidaMaxima() * 0.03);
        }
    }
}