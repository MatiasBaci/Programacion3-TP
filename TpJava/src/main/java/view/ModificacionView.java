package view;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Modificacion;

public abstract class ModificacionView{

    protected Modificacion unaModificacion;

    public ModificacionView(Modificacion unaModificacion){
        this.unaModificacion = unaModificacion;
    }

    protected abstract void mostrar(Cualidades unaCualidad);

}
