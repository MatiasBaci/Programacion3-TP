package view;
import org.fiuba.algoritmos3.Jugador;
import Item.*;
import org.fiuba.algoritmos3.Pokemon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JugadorView {

    private String nombre;

    private Map<String, ItemView> itemsView;

    private Map<String, PokemonView> misPokemonesView;

    private PokemonView pokemonActualView;

    private ItemViewFactory itemFactory;

    private PokemonFactory pokemonFactory;

    private JugadorFactory jugadorFactory;
    private JugadorView jugadorAdversarioView;

    public JugadorView(Jugador jugador){
        this.pokemonFactory = new PokemonFactory();
        this.jugadorFactory = new JugadorFactory();
        this.nombre = jugador.getNombre();
        this.itemsView = new HashMap<String, ItemView>();
        itemFactory = new ItemViewFactory();
        jugador.getItems().forEach((k, v) -> itemsView.put(k, itemFactory.createItemView(v)));
        this.misPokemonesView = new HashMap<String, PokemonView>();
        pokemonFactory = new PokemonFactory();
        jugador.getMisPokemones().forEach((k, v) -> misPokemonesView.put(k, pokemonFactory.createPokemonView(v)));
    }

    public void setPokemonActualView(Pokemon pokemon) {
        this.pokemonActualView = this.pokemonFactory.createPokemonView(pokemon);
    }

    public void setJugadorAdversarioView(Jugador jugadorAversario){
        this.jugadorAdversarioView = this.jugadorFactory.createJugadorView(jugadorAversario);
    }

    public String getNombre() {
        return nombre;
    }

    public JugadorView getJugadorAdversarioView() {
        return jugadorAdversarioView;
    }

    public void mostrarPokemones() {
        System.out.println("-----------------------------------------------------------------");
        misPokemonesView.forEach((k, v) -> v.mostrar());
        System.out.println("-----------------------------------------------------------------");
    }
    public void mostrarPokemonActual(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Pokemon de " + this.nombre);
        pokemonActualView.mostrar();
        System.out.println("-----------------------------------------------------------------");
    }

    public void mostratItems(){

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Items de " + this.nombre);
        itemsView.forEach((k, v) -> v.mostrar());
        System.out.println("-----------------------------------------------------------------");


    }

    public void mostratHabilidadesPokemonActual() {
        System.out.println("Las habilidades de " + pokemonActualView.getNombre() + " actuales son: ");
        pokemonActualView.mostrarHabilidades();
    }


}
