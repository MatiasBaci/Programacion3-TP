package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;

public class CambioDeTurnoEvent extends Event {
    public static EventType<CambioDeTurnoEvent> CAMBIO_DE_TURNO_EVENT = new EventType<>("CambioDeTurnoEvent");

    public CambioDeTurnoEvent() {
        super(CAMBIO_DE_TURNO_EVENT);
    }
}
