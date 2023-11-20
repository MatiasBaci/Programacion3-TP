package orgFiuba.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;
@JsonTypeName("Curar Todo")
public class PocionCuracionEstados extends ItemsEstado {
    public PocionCuracionEstados(String nombre, int cantidad, Modificacion unaModificacion){

        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }
    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoCurarTodo(cualidades.obtenerEstadosActuales());
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }

}
