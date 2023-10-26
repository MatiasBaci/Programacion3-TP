package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

public class MegaPocion extends ItemsCuracion {

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
        boolean realizo = this.realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 50);
        return realizo;
    }

}
