package Item;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

public class Revivir extends ItemsEstado {

    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoRevivir(cualidades.getEstadosActuales());
        //CasoBorde --- realizo devuelve False porque no esta muerto y el pokemon tiene Varios estados, pero modificar hace el cambio
        this.unaModificacion.modificar(cualidades, (int) cualidades.getVidaMaxima());
        return realizo;
    }

}
