package Item;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

public class Pocion extends ItemsCuracion {

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades){

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 25);
        return realizo;
    }
}
