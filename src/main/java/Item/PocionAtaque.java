package Item;

import Item.Item;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class PocionAtaque extends Item {

    public PocionAtaque(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
        this.tipo = "Estadistica";
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        boolean realizo = this.realizarUsadoItemsDeEstadisitcas(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 1);
        return realizo;
    }

    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Aumenta 10% el ataque - Cantidad: " + cantidad);
    }
}

