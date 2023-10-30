package view;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.ModificacionEstado;
import org.fiuba.algoritmos3.ModificacionEstadoInhabilitado;

public class ModificacionFactory {

    public ModificacionView createModificacionView(Modificacion modificacion){
        if(modificacion.getClass() == ModificacionEstado.class){
            return new ModificacionEstadoView(modificacion);
        }
        if(modificacion.getClass() == ModificacionEstadoInhabilitado.class){
            return new ModificacionEstadoInhabilitadoView(modificacion);
        }
        return new ModificacionVidaView(modificacion);
    }
}
