package Item;

import org.fiuba.algoritmos3.Cualidades;

public abstract class ItemsEstadistica extends Item implements validarItemEstadistica{

    public ItemsEstadistica(String unNombre, int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    public abstract void mostrarItem();
    @Override
    public boolean realizarUsadoItemsDeEstadisitcas(Cualidades cualidades){
        if(cualidades.getVida() != 0){
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
