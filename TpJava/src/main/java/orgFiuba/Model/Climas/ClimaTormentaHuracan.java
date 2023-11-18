package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.CLIMA_HURACAN;
import static orgFiuba.Constantes.PORCENTAJE_DANIO_CLIMA_ABRASIVO;

public class ClimaTormentaHuracan extends Clima{

    public ClimaTormentaHuracan(){
        this.nombre = CLIMA_HURACAN;
    }

    @Override
    public void aplicarEfectoClima(Cualidades cualidades) {

        cualidades.getTipo().calcularMultiplicadorClima(this.nombre);
        if(cualidades.getTipo().verSiEsAbrasivo(this.nombre)){
            cualidades.recibirDanio(cualidades.getVidaMaxima() * PORCENTAJE_DANIO_CLIMA_ABRASIVO);
        }
    }
}
