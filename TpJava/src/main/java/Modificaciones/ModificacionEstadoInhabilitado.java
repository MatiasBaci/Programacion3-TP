package Modificaciones;

import Estados.EstadoNormal;
import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_INHABILITADO;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if(!unaCualidad.estaConsciente()){
            //unaCualidad.cambiarseEstado(new EstadoNormal()); // cambiar esto, cambiarLosEstadosA-> CASOdonde revivr se le quita los estados
            unaCualidad.cambiarLosEstadosA(new EstadoNormal());
        }
        if(unaCualidad.getVida() == 0) {
            unaCualidad.aumentarVida(etapas);
        }

    }

    @Override
    public String obtenerNombreModificacion() {
        return MODIFICACION_INHABILITADO;
    }
}
