package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

public class HiperPocion extends ItemsCuracion {


    public HiperPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 100);
        return realizo;
    }

}

