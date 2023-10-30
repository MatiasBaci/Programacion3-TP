package view;
import org.fiuba.algoritmos3.Jugador;
import Item.*;
import org.fiuba.algoritmos3.Pokemon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public PokemonView getPokemonActualView() {
        return pokemonActualView;
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


    public void mostrarSeSeleccionoUnPokemon(String nombrePokemon){
        System.out.println("Seleccionaste el pokemon -> " + nombrePokemon);
        System.out.println("\n");
    }

    public static void mostrarHabilidadNoExiste() {
        System.out.println("ERROR: LA HABILIDAD NO EXISTE. ");
        System.out.println("\n");
    }

    public void mostrarCasosDeEleccion(String nombrePokemon, Pokemon pokemonActual, Map<String, Pokemon> misPokemones){

        if (misPokemones.get(nombrePokemon) == null) {
            System.out.println("ERROR: NO SE ENCONTRO EL POKEMON EN LA MOCHILA.");
            System.out.println("\n");
            return;
        }
        else if (misPokemones.get(nombrePokemon).getCualidades(). getVida() == 0) {
            System.out.println("ERROR: EL POKEMON NO TIENE VIDA ");
            System.out.println("\n");
            return;
        }
        else if(pokemonActual != null){
            if(Objects.equals(nombrePokemon, pokemonActual.getNombre())) {
                System.out.println("ERROR: ESTAS ELIGIENDO A TU POKEMON ACTUAL ");
                System.out.println("\n");
                return;
            }
        }
        this.mostrarSeSeleccionoUnPokemon(nombrePokemon);

    }

    public String getNombrePokemonActual() {
        return this.pokemonActualView.getNombre();
    }
}