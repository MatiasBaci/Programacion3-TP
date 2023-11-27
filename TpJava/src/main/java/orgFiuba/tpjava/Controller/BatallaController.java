package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class BatallaController {

    @FXML
    VBox pantalla;
    @FXML
    HBox pokemones;
    @FXML
    VBox pokemonJ1Box;
    @FXML
    HBox pokemonJ1Stats;
    @FXML
    ProgressBar pokemonJ1HP;
    @FXML
    Text pokemonJ1StatsText;
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
    ProgressBar pokemonJ2HP;
    @FXML
    Text pokemonJ2StatsText;
    @FXML
    HBox dialogoYMenuBox;
    @FXML
    VBox dialogoBox;
    @FXML
    GridPane menuGrid;
    @FXML
    Button atacarButton;
    @FXML
    Button pokemonButton;
    @FXML
    Button itemButton;
    @FXML
    Button rendirseButton;


    public void inicializar(Juego juego, JuegoController juegoController) {

        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        //this.pokemonJ1View = pokemonResourceFactory.createPokemonBattleView(juego.getJugador1().getPokemonActual(), "Espalda");
        //this.pokemonJ2View = pokemonResourceFactory.createPokemonBattleView(juego.getJugador2().getPokemonActual(), "Frente");

        this.pokemonJ1StatsText.setText(juego.getJugador1().getPokemonActual()
                .getNombre() + "\n" +
                "Lv " + juego.getJugador1().getPokemonActual().getCualidades().getNivel());
        this.pokemonJ1HP.setProgress(juego.getJugador1().getPokemonActual().getCualidades().getPorcentajeVida());
        this.pokemonJ2StatsText.setText(juego.getJugador2().getPokemonActual()
                .getNombre() + "\n" +
                "Lv " + juego.getJugador2().getPokemonActual().getCualidades().getNivel());
        this.pokemonJ2HP.setProgress(juego.getJugador2().getPokemonActual().getCualidades().getPorcentajeVida());

        this.pokemonJ1View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugador1().getPokemonActual(), "Espalda").getImage());
        this.pokemonJ1View.setFitHeight(this.pokemonJ1View.getImage().getHeight()*3);
        this.pokemonJ1View.setFitWidth(this.pokemonJ1View.getImage().getWidth()*3);
        this.pokemonJ2View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugador2().getPokemonActual(), "Frente").getImage());
        this.pokemonJ2View.setFitHeight(this.pokemonJ2View.getImage().getHeight()*3);
        this.pokemonJ2View.setFitWidth(this.pokemonJ2View.getImage().getWidth()*3);

        this.atacarButton.setOnAction(event -> {
            crearMenuAtaques(juego.getJugador1().getPokemonActual());
        });
    }

    public void crearMenuAtaques(Pokemon pokemon) {
        GridPane ataques = new GridPane();

        List<Habilidad> habilidades = new ArrayList<>(pokemon.getMisHabilidades().values());

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Button ataque = new Button(habilidades.get(index).getNombre());
                ataque.setPrefHeight(50);
                ataque.setPrefWidth(100);
                ataque.setOnAction(event -> {
                    //pokemon.atacar(habilidades.get(index), pokemon);

                });
                ataques.add(ataque, j, i);
                index++;
            }
        }

        this.dialogoBox.getChildren().add(ataques);
    }
}
