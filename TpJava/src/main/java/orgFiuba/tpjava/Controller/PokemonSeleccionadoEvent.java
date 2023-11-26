package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;

public class PokemonSeleccionadoEvent extends Event {
    public PokemonSeleccionadoEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public Jugador getJugador() {
        return null;
    }
}
