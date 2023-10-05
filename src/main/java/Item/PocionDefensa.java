package Item;

import Item.Item;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class PocionDefensa extends Item {

    private Modificacion unaModificacion;

    public PocionDefensa(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.realizarUsadoItemsDeEstadisitcas(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 1);
        return itemUsado;


    }
    @Override
    public void mostrarItem() {
        System.out.println(this.nombre + ": Aumenta 10% la defensa - Cantidad: " + this.cantidad);
    }
}