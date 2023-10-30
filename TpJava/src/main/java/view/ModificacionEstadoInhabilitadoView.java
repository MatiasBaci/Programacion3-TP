package view;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public class ModificacionEstadoInhabilitadoView extends ModificacionView{

    public ModificacionEstadoInhabilitadoView(Modificacion unaModifcacion){
        super(unaModifcacion);
    }

    public void mostrar(Cualidades unaCualidad){

        if(unaCualidad.estaConsciente()){
            System.out.println(" ");
            System.out.println("El Pokemon no se puede revivir ya que no esta Inhabilitado");
        }

    }
}
