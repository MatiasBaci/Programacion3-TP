package Item;

import Item.Item;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class HiperPocion extends Item {


    public HiperPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 100);
        return realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());
    }

    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 100 de vida - Cantidad: " + cantidad);
    }
}

