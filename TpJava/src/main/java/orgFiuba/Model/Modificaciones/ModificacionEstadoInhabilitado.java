package orgFiuba.Model.Modificaciones;

import orgFiuba.Model.Estados.EstadoNormal;
import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.MODIFICACION_INHABILITADO;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if(!unaCualidad.estaConsciente()){
            unaCualidad.cambiarLosEstadosA(new EstadoNormal());
            //unaCualidad.aumentarVida(etapas);
        }
        if (unaCualidad.getVida() == 0) {
            unaCualidad.aumentarVida(etapas);
        }
    }

    @Override
    public String obtenerNombreModificacion() {
        return MODIFICACION_INHABILITADO;
    }
}
