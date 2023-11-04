package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_SOLEADO;

public class ClimaSoleado extends Clima{

    public ClimaSoleado(){
        this.nombre = CLIMA_SOLEADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades){

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}

