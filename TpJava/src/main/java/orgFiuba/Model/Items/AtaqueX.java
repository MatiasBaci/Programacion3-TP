package orgFiuba.Model.Items;

import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;

public class AtaqueX extends ItemsEstadistica {

    public AtaqueX(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
        boolean realizo = this.realizarUsadoItemsDeEstadisitcas(cualidades);
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }
}

