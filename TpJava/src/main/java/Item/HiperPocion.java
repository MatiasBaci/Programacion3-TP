package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class HiperPocion extends Item {


    public HiperPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 100);
        return itemUsado;
    }

    public void mostrarItem() {
        System.out.println(this.nombre + ": Restaura 100 de vida - Cantidad: " + this.cantidad);
    }
}

