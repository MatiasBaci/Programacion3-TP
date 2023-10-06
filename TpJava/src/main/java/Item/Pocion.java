package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class Pocion extends ItemsCuracion {

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }
    @Override
    public boolean aplicarItem(Pokemon unPokemon){

        boolean realizo = realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 25);
        return realizo;
    }

    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 25 de vida - Cantidad: " + cantidad);
    }
}
