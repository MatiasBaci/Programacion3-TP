package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_SOLEADO;

public class ClimaSoleado extends Clima{

    public ClimaSoleado(){
        this.nombre = CLIMA_SOLEADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades){

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}

