package Item;

import org.fiuba.algoritmos3.*;
public abstract class Item {

    protected final String nombre;
    protected int cantidad;
    protected Modificacion unaModificacion;

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
            System.out.println("No tiene este tipo de items");
            return false;
        }
        else{
            System.out.print("Acaba de seleccionar el siguiente Item: " + nombre);
            System.out.println("\n");
            return this.aplicarItem(cualidades);
        }
    }
}
