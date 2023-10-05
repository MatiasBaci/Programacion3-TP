package Item;
import static org.fiuba.algoritmos3.Constantes.*;

import Item.Item;
import org.fiuba.algoritmos3.EstadoNormal;
import org.fiuba.algoritmos3.Pokemon;

import java.util.Objects;

public class PocionCuracionEstados extends Item {
    public PocionCuracionEstados(String nombre, int cantidad){
        super(nombre, cantidad);
    }
    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        if (!Objects.equals(unPokemon.suEstadoEs(), ESTADO_NORMAL) && unPokemon.estaConciente()) {
            this.realizarUsadoItemsDeEstado(unPokemon.getEstadoActual());
            unPokemon.cambiarseEstado(new EstadoNormal());
            return itemUsado;
        } else {
            System.out.println(" ");
            System.out.println("No se puede aplicar este item a un Pokemon Inhabilitado o Normal.");
            return false;
        }
    }
    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Elimina los Estado del pokemon - Cantidad: " + cantidad);
    }
}
