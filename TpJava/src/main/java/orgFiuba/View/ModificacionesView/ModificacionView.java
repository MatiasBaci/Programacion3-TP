package orgFiuba.View.ModificacionesView;

import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    public abstract void mostrar(Cualidades unaCualidad);

}
