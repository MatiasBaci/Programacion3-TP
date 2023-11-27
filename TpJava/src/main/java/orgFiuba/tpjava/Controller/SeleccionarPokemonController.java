package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionarPokemonController {

    @FXML
    public HashMap<String, ImageView> pokemonMenuViews;

    public List<Pokemon> pokemones;
    private Jugador jugador;
    private JuegoController juegoController;
    @FXML
    public GridPane gridPanePokemones;

    public void inicializar(Jugador jugador, JuegoController juegoController) throws IOException {
        this.jugador = jugador;
        this.juegoController = juegoController;
        this.pokemonMenuViews = new HashMap<>();
        this.pokemones = new ArrayList<>();
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        this.jugador.getMisPokemones().forEach((k, v) -> pokemones.add(v));

        HBox pokemonView;
        VBox pokemonStats;
        VBox pokemonIconoYNombre;
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 2; col++) {

                pokemonView = new HBox();
                pokemonStats = new VBox();
                pokemonIconoYNombre = new VBox();

                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonMenuView(pokemones.get(index), pokemones.get(index).estaConsciente()));
                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonName(pokemones.get(index)));

                pokemonStats.getChildren().add(pokemonResourceFactory.createPokemonStats(pokemones.get(index)));

                pokemonView.getChildren().add(pokemonIconoYNombre);
                pokemonView.getChildren().add(pokemonStats);

                pokemonView.setOnMouseClicked(createImageViewClickHandler(pokemonView, this.juegoController, this.jugador, pokemones.get(index)));

                gridPanePokemones.add(pokemonView, col, row);

                index++;
            }
        }
    }

    // Create an event handler for ImageView click events
    private EventHandler<MouseEvent> createImageViewClickHandler(HBox imageView, JuegoController juegoController, Jugador jugador, Pokemon pokemon) {
        return event -> {
            System.out.println("ImageView clicked! " + imageView.getId());

            // Call a function from your object
            juegoController.handle(new PokemonSeleccionadoEvent(jugador, pokemon)); // Replace yourFunction with the actual function name

            // Add your additional event handling code here
        };
    }
}
