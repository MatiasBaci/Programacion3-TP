package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class Pocion extends Item {

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }
    @Override
    public boolean aplicarItem(Pokemon unPokemon){

        this.realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 25);
        return itemUsado;

    }

    @Override
    public void mostrarItem() {
        System.out.println(this.nombre + ": Restaura 25 de vida - Cantidad: " + this.cantidad);
    }
}
