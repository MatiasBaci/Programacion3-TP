package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_LLUVIA;

public class ClimaLLuvia extends Clima{

    public ClimaLLuvia(){
        this.nombre = CLIMA_LLUVIA;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades){

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
