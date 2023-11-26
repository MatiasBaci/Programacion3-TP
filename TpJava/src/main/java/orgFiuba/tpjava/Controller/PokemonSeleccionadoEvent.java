package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;

public class PokemonSeleccionadoEvent extends Event {

    public static EventType<PokemonSeleccionadoEvent> POKEMON_SELECCIONADO_EVENT = new EventType<>("Pokemon seleccionado Event");

   public PokemonSeleccionadoEvent(){
       super(POKEMON_SELECCIONADO_EVENT);
   }


}
