package Item;
import static org.fiuba.algoritmos3.Constantes.*;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

import java.util.Objects;

public class PocionCuracionEstados extends ItemsEstado {
    public PocionCuracionEstados(String nombre, int cantidad, Modificacion unaModificacion){

        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }
    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = realizarUsadoCurarTodo(cualidades.getEstadoActual());
        this.unaModificacion.modificar(cualidades, 1);
        return realizo;
    }
    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Elimina los Estado del pokemon - Cantidad: " + cantidad);
    }
}
