package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.Model.Juego;

public class BatallaController {

    @FXML
    AnchorPane pantalla;
    @FXML
    HBox pokemones;
    @FXML
    VBox pokemonJ1Box;
    @FXML
    HBox pokemonJ1Stats;
    @FXML
    HBox pokemonJ1ViewBox;
    @FXML
    ImageView pokemonJ1View;
    @FXML
    VBox pokemonJ2Box;
    @FXML
    HBox pokemonJ2ViewBox;
    @FXML
    ImageView pokemonJ2View;
    @FXML
    HBox pokemonJ2Stats;
    @FXML
    HBox dialogoYMenuBox;


    public void inicializar(Juego juego, JuegoController juegoController) {

        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        //this.pokemonJ1View = pokemonResourceFactory.createPokemonBattleView(juego.getJugador1().getPokemonActual(), "Espalda");
        //this.pokemonJ2View = pokemonResourceFactory.createPokemonBattleView(juego.getJugador2().getPokemonActual(), "Frente");



        this.pokemonJ1View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugador1().getPokemonActual(), "Espalda").getImage());
        this.pokemonJ2View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugador2().getPokemonActual(), "Frente").getImage());
    }
}
