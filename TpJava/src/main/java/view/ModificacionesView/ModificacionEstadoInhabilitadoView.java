package view.ModificacionesView;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

import static org.fiuba.algoritmos3.Constantes.*;

public class ModificacionEstadoInhabilitadoView extends ModificacionView{

    public ModificacionEstadoInhabilitadoView(Modificacion unaModifcacion){
        super(unaModifcacion);
    }

    public void mostrar(Cualidades unaCualidad){

        if(unaCualidad.estaConsciente()){
            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon no se puede revivir ya que no esta Inhabilitado" + ANSI_RESET);
        }

    }
}
