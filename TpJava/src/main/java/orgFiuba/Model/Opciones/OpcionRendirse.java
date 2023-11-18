package orgFiuba.Model.Opciones;

import orgFiuba.Model.Jugador;
import orgFiuba.View.GeneralView;

public class OpcionRendirse implements Opcion{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView) {

        generalView.mostrarMensajeRendirse();

        jugador.setAtacante(false);
        jugador.perder();
    }
}
