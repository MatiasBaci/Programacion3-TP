package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;

public class JugadorNombradoEvent extends Event {

    public static EventType<JugadorNombradoEvent> JUGADOR_NOMBRADO_EVENT = new EventType<>("Jugador Nombrado Event");

    private Jugador jugador;

    public JugadorNombradoEvent(Jugador jugador)
    {
        super(JUGADOR_NOMBRADO_EVENT);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return this.jugador;
    }
}
