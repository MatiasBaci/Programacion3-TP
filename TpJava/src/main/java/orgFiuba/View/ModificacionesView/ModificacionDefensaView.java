package orgFiuba.View.ModificacionesView;

import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;

import static orgFiuba.Constantes.ANSI_RESET;
import static orgFiuba.Constantes.ANSI_ROJO;

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
