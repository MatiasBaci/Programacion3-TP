package view;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public class ModificacionVidaView extends ModificacionView {

    public ModificacionVidaView(Modificacion unaModificacion) {
        super(unaModificacion);
    }

    public void mostrar(Cualidades unaCualidad) {
        if (unaCualidad.getVida() == 0) {

            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede curar.");
        } else if (unaCualidad.getVida() == unaCualidad.getVidaMaxima()) {

            System.out.println(" ");
            System.out.println("El Pokemon tiene toda la vida, no se puede curar.");
        }

    }
}