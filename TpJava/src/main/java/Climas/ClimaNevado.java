package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_NEVADO;

public class ClimaNevado extends Clima{

    public ClimaNevado(){
        this.nombre = CLIMA_NEVADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
