package Item;

import org.fiuba.algoritmos3.Estadisticas;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public abstract class ItemsCuracion extends Item implements validarItemCuracion{
    protected Modificacion unaModificacion;

    public ItemsCuracion(String unNombre,int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public abstract void mostrarItem();
    @Override
    public boolean realizarUsadoItemsDeCuracion(Estadisticas estadistica){
        if(estadistica.getVida() != 0 && estadistica.getVida() != estadistica.getVidaMaxima()){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){return true;}
}
