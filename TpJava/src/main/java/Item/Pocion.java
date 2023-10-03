package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class Pocion extends Item {

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }

    public boolean aplicarItem(Pokemon unPokemon){

        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 25);
        return realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());

    }

    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 25 de vida - Cantidad: " + cantidad);
    }
}
