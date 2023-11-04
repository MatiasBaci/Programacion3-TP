package Item;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;
public abstract class Item {

    protected final String nombre;
    protected int cantidad;
    public Modificacion unaModificacion;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public int getCantidad() {return cantidad;}

    public String getNombre() {return nombre;}

    public Modificacion getUnaModificacion() {
        return unaModificacion;
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    public abstract boolean esUnItemDeSoloCampoDeBatalla();
    public boolean realizarCasosDeApliacion(Cualidades cualidades){
        if (this.cantidad == 0) {
            return false;
        }
        else{
            return this.aplicarItem(cualidades);
        }
    }
}
