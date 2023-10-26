package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

public class DefensaX extends ItemsEstadistica {

    private Modificacion unaModificacion;

    public DefensaX(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
        boolean realizo = realizarUsadoItemsDeEstadisitcas(cualidades);
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }
}
