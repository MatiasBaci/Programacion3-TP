package view.ModificacionesView;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    public abstract void mostrar(Cualidades unaCualidad);

}
