package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_LLUVIA;

public class ClimaLLuvia extends Clima{

    public ClimaLLuvia(){
        this.nombre = CLIMA_LLUVIA;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades){

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
