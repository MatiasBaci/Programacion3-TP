package view;

import org.fiuba.algoritmos3.Jugador;

public class JugadorFactory {

    public JugadorView createJugadorView(Jugador jugador){
        return new JugadorView(jugador);
    }
}
