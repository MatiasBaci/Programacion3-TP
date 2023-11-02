package Climas;

import Pokemones.Pokemon;

import static org.fiuba.algoritmos3.Constantes.CLIMA_TORMENTA_DE_ARENA;

public class ClimaTormentaArena extends Clima{

    public ClimaTormentaArena(){
        this.nombre = CLIMA_TORMENTA_DE_ARENA;
    }

    @Override
    public void aplicarEfectoClima(Pokemon pokemon) {

        pokemon.getTipo().calcularMultiplicadorClima(this.nombre);
        if(pokemon.getTipo().verSiEsAbrasivo(this.nombre)){
            pokemon.getCualidades().recibirDanio(pokemon.getCualidades().getVidaMaxima() * 0.03);
            System.out.println("Se bajo la vida");
        }
    }
}
