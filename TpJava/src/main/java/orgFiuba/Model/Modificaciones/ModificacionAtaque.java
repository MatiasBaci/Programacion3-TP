package orgFiuba.Model.Modificaciones;

import orgFiuba.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static orgFiuba.Constantes.MODIFICACION_ATAQUE;

@JsonTypeName("ataque")
public class ModificacionAtaque implements Modificacion {


    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarAtaque(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_ATAQUE;
    }

}