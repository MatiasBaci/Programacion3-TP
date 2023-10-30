package view;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public class ModificacionEstadoView extends ModificacionView{

    public ModificacionEstadoView(Modificacion unaModificacion){
        super(unaModificacion);
    }

    public void mostrar(Cualidades unaCualidad){

        if(!unaCualidad.estaConsciente()) {
            System.out.println(" ");
            System.out.println("No se puede aplicar este item a un Pokemon Inhabilitado o Normal.");
        }
    }

}
