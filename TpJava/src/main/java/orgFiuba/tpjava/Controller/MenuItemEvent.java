package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

public class MenuItemEvent extends Event{

    private Jugador jugador;

    public static EventType<MenuItemEvent> APLICAR_ITEM_EVENT = new EventType<>("Aplicar Item Event");

    public MenuItemEvent(Jugador jugador){
        super(APLICAR_ITEM_EVENT);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
