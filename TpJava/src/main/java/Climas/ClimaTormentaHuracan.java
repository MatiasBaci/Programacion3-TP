package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.CLIMA_HURACAN;
import static org.fiuba.algoritmos3.Constantes.PORCENTAJE_DANIO_CLIMA_ABRASIVO;

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
