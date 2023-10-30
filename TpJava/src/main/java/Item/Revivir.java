package Item;

import org.fiuba.algoritmos3.EstadoNormal;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

public class Revivir extends ItemsEstado {

    private Modificacion unaModificacion;


    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoRevivir(cualidades.getEstadosActuales());
        this.unaModificacion.modificar(cualidades, (int) cualidades.getVidaMaxima());
        return realizo;
    }

}
