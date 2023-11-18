package orgFiuba.Model.Modificaciones;

import orgFiuba.Model.Estados.EstadoNormal;
import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.MODIFICACION_ESTADO;

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
