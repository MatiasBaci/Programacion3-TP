package view.ModificacionesView;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;
import static org.fiuba.algoritmos3.Constantes.ANSI_ROJO;

public class ModificacionVidaView extends ModificacionView {

    public ModificacionVidaView(Modificacion unaModificacion) {
        super(unaModificacion);
    }

    public void mostrar(Cualidades unaCualidad) {
        if (unaCualidad.getVida() == 0) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon esta Inhabilitado, no se puede curar." + ANSI_RESET);
        } else if (unaCualidad.getVida() == unaCualidad.getVidaMaxima()) {

            System.out.println(" ");
            System.out.println(ANSI_ROJO + "El Pokemon tiene toda la vida, no se puede curar." + ANSI_RESET);
        }

    }
}