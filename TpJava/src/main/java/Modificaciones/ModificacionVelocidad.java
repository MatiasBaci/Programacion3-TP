package Modificaciones;

import Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_VELOCIDAD;
@JsonTypeName("velocidad")
public class ModificacionVelocidad implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarVelocidad(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_VELOCIDAD;
    }
}
