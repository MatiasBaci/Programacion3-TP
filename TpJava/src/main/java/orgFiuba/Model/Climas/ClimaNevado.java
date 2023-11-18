package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_NEVADO;

public class ClimaNevado extends Clima{

    public ClimaNevado(){
        this.nombre = CLIMA_NEVADO;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);

    }
}
