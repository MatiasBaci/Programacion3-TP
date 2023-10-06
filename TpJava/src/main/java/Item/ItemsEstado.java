package Item;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.Pokemon;

import java.util.Objects;

import static org.fiuba.algoritmos3.Constantes.ESTADO_INHABILITADO;
import static org.fiuba.algoritmos3.Constantes.ESTADO_NORMAL;

public abstract class ItemsEstado extends Item implements validarItemEstado {

    public ItemsEstado(String unNombre, int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public abstract void mostrarItem();
    @Override
    public boolean realizarUsadoCurarTodo(Estado unEstado){
        if(!Objects.equals(unEstado.getNombre(), ESTADO_NORMAL) && !Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean realizarUsadoRevivir(Estado unEstado){
        if(Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){
        return true;
    }
}
