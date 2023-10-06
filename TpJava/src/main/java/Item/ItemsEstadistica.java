package Item;

import org.fiuba.algoritmos3.Estadisticas;
import org.fiuba.algoritmos3.Pokemon;

public abstract class ItemsEstadistica extends Item implements validarItemEstadistica{

    public ItemsEstadistica(String unNombre, int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public abstract void mostrarItem();
    @Override
    public boolean realizarUsadoItemsDeEstadisitcas(Estadisticas estadistica){
        if(estadistica.getVida() != 0){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){
        return false;
    }
}
