package view.ModificacionesView;

import Pokemones.Cualidades;
import Modificaciones.Modificacion;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    public abstract void mostrar(Cualidades unaCualidad);

}
