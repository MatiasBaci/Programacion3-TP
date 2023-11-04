package Modificaciones;

import Estados.EstadoNormal;
import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_ESTADO;

public class ModificacionEstado implements  Modificacion{

    public void modificar(Cualidades cualidades, int etapas){

        if (cualidades.estaConsciente()) {
            cualidades.cambiarLosEstadosA(new EstadoNormal());
        }
    }

    public  String obtenerNombreModificacion(){
        return MODIFICACION_ESTADO;
    }
}
