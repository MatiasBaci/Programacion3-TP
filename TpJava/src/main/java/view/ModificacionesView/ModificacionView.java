package view.ModificacionesView;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    public abstract void mostrar(Cualidades unaCualidad);

}
