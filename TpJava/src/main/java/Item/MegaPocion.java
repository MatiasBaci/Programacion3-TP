package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class MegaPocion extends Item {

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 50);
        return itemUsado;

    }
    @Override
    public void mostrarItem() {
        System.out.println(this.nombre + ": Restaura 50 de vida - Cantidad: " + this.cantidad);
    }
}
