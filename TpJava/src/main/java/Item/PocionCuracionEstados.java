package Item;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

import java.util.Objects;

public class PocionCuracionEstados extends ItemsEstado {
    public PocionCuracionEstados(String nombre, int cantidad, Modificacion unaModificacion){

        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }
    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoCurarTodo(cualidades.getEstadosActuales());
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }

}
