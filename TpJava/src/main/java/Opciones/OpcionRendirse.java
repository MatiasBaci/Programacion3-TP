package Opciones;

import org.fiuba.algoritmos3.Jugador;
import view.GeneralView;

public class OpcionRendirse implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView) {

        generalView.mostrarMensajeRendirse();

        jugador.setAtacante(false);
        jugador.perder();
    }
}
