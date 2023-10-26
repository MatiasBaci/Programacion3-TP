package Item;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public abstract class ItemsCuracion extends Item implements validarItemCuracion{

    public ItemsCuracion(String unNombre,int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    @Override
    public boolean realizarUsadoItemsDeCuracion(Cualidades cualidades){
        if(cualidades.getVida() != 0 && cualidades.getVida() != cualidades.getVidaMaxima()){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){return true;}
}
