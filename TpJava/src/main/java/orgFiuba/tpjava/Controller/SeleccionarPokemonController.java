package orgFiuba.tpjava.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.IOException;

public class SeleccionarPokemonController {

    @FXML
    public HashMap<String, ImageView> pokemonMenuViews;

    public List<Pokemon> pokemones;

    private Jugador jugador;

    private JuegoController juegoController;
    @FXML
    public GridPane gridPanePokemones;

    public void inicializar(Jugador jugador, JuegoController juegoController){
        this.jugador = jugador;
        this.juegoController = juegoController;
        this.pokemonMenuViews = new HashMap<>();
        this.pokemones = new ArrayList<>();
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        this.jugador.getMisPokemones().forEach((k, v) -> pokemones.add(v));

        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 2; col++) {
                gridPanePokemones.add(pokemonResourceFactory.createPokemonMenuView(pokemones.get(index), pokemones.get(index).estaConsciente()), col, row);
                index++;
            }
        }
    }

    public void elegirPokemon(ActionEvent event) throws IOException {

        this.juegoController.handle(new PokemonSeleccionadoEvent());

    }
}
