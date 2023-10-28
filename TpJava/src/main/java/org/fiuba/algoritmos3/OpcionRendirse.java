package org.fiuba.algoritmos3;

import view.GeneralView;

public class OpcionRendirse implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView) {

        generalView.mostrarMensajeRendirse();

        jugador.setAtacante(false);
        jugador.perder();
    }
}
