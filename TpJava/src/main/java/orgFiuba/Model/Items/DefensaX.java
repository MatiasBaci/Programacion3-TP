package orgFiuba.Model.Items;

import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;

public class DefensaX extends ItemsEstadistica {

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
