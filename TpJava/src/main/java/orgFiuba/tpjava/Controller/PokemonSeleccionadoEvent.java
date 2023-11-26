package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventType;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonSeleccionadoEvent extends Event {

    public static EventType<PokemonSeleccionadoEvent> POKEMON_SELECCIONADO_EVENT = new EventType<>("Pokemon seleccionado Event");
    private final Pokemon pokemon;
    private final Jugador jugador;

    public PokemonSeleccionadoEvent(Jugador jugador, Pokemon pokemon){
       super(POKEMON_SELECCIONADO_EVENT);
       this.jugador = jugador;
       this.pokemon = pokemon;
   }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
