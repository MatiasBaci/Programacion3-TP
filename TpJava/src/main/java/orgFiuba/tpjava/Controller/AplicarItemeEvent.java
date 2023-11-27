package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

public class AplicarItemeEvent extends Event{

    private Jugador jugador;

    private Item item;

    public static EventType<AplicarItemeEvent> APLICAR_ITEM_EVENT = new EventType<>("Aplicar Item Event");

    public AplicarItemeEvent(Jugador jugador, Item item){
        super(APLICAR_ITEM_EVENT);
        this.jugador = jugador;
        this.item = item;

    }

    public Item getItem() {
        return item;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
