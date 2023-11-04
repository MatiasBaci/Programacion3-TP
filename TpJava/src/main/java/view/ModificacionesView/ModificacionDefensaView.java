package view.ModificacionesView;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;
import static org.fiuba.algoritmos3.Constantes.ANSI_ROJO;

public class ModificacionDefensaView extends ModificacionView{

    public ModificacionDefensaView(Modificacion unaModificacion){
        super(unaModificacion);

    }

    public void mostrar(Cualidades unaCualidad){
        if (unaCualidad.getVida() == 0) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon esta Inhabilitado, no se puede aplicar el item." + ANSI_RESET);
        }

    }
}
