package view.ModificacionesView;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;
import static org.fiuba.algoritmos3.Constantes.ANSI_ROJO;

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
