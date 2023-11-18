package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_NIEBLA;

public class ClimaNiebla extends Clima{

    public ClimaNiebla(){
        this.nombre = CLIMA_NIEBLA;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
