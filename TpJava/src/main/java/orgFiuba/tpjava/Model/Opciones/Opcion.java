package orgFiuba.tpjava.Model.Opciones;

import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.View.GeneralView;

public interface Opcion {

    public abstract void aplicarOpcion(Jugador jugador, GeneralView generalView);

}
