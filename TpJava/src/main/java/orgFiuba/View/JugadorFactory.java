package orgFiuba.View;

import orgFiuba.Model.Jugador;

public class JugadorFactory {

    public JugadorView createJugadorView(Jugador jugador){
        return new JugadorView(jugador);
    }
}
