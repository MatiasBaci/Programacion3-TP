package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NIEBLA;

public class ClimaNiebla extends Clima{

    public ClimaNiebla(){
        this.nombre = CLIMA_NIEBLA;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
