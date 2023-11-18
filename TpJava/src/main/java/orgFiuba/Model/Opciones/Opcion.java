package orgFiuba.Model.Opciones;

import orgFiuba.Model.Jugador;
import orgFiuba.View.GeneralView;

public interface Opcion {

    public abstract void aplicarOpcion(Jugador jugador, GeneralView generalView);

}
