package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NORMAL;

public class ClimaNormal extends Clima{

    public ClimaNormal(){
        this.nombre = CLIMA_NORMAL;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
