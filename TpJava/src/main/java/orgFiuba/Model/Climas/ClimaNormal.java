package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_NORMAL;

public class ClimaNormal extends Clima{

    public ClimaNormal(){
        this.nombre = CLIMA_NORMAL;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
    }
}
