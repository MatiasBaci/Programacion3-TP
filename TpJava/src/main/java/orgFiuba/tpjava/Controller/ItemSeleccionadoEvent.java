package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

public class ItemSeleccionadoEvent extends Event {

    private Jugador jugador;
    private Item item;
    public static EventType<CambioDeTurnoEvent> ITEM_SELECCIONADO_EVENT = new EventType<>("Item Seleccionado Event");

    public ItemSeleccionadoEvent(Jugador jugador, Item item) {
        super(ITEM_SELECCIONADO_EVENT);
        this.item = item;
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Item getItem() {
        return item;
    }
}
