package Item;
import static org.fiuba.algoritmos3.Constantes.*;
import org.fiuba.algoritmos3.EstadoNormal;
import org.fiuba.algoritmos3.Pokemon;

import java.util.Objects;

public class PocionCuracionEstados extends ItemsEstado {
    public PocionCuracionEstados(String nombre, int cantidad){
        super(nombre, cantidad);
    }
    @Override
    public boolean aplicarItem(Pokemon unPokemon) {
        boolean realizo = false;
        if (!Objects.equals(unPokemon.suEstadoEs(), ESTADO_NORMAL) && unPokemon.estaConciente()) {
            realizo = this.realizarUsadoCurarTodo(unPokemon.getEstadoActual());
            unPokemon.cambiarseEstado(new EstadoNormal());
        } else {
            System.out.println(" ");
            System.out.println("No se puede aplicar este item a un Pokemon Inhabilitado o Normal.");
        }
        return realizo;
    }
    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Elimina los Estado del pokemon - Cantidad: " + cantidad);
    }
}
