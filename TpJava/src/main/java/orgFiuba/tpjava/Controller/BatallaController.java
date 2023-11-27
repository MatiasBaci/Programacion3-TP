package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Controller.Eventos.AtaqueSeleccionadoEvent;
import orgFiuba.tpjava.Controller.Eventos.MenuCambiarPokemonEvent;
import orgFiuba.tpjava.Controller.Eventos.MenuItemEvent;
import orgFiuba.tpjava.Controller.Eventos.RendirseEvent;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BatallaController {

    @FXML
    VBox pantalla;
    @FXML
    VBox climaOverlay;
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
    TextArea dialogo;
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
    private JuegoController juegoController;


    public void inicializar(Juego juego, JuegoController juegoController) {

        this.juegoController = juegoController;
        this.juegoController.setBatallaController(this);
        this.crearVentanaBatalla(juego);
    }

    public void crearVentanaBatalla(Juego juego) {

        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        String clima = juego.getClimaActual().getNombre();
        try {
            Background background = pokemonResourceFactory.createClimaOverlay(clima, this.climaOverlay.getHeight(), this.climaOverlay.getWidth());
            this.climaOverlay.setBackground(background);
        } catch (Exception e) {
            this.climaOverlay.setBackground(null);
        }

        this.pokemonJ1StatsText.setText(juego.getJugadorActual().getPokemonActual()
                .getNombre() + "\n" +
                "Lv " + juego.getJugadorActual().getPokemonActual().getCualidades().getNivel());
        this.pokemonJ1HP.setProgress(juego.getJugadorActual().getPokemonActual().getCualidades().getPorcentajeVida());
        this.pokemonJ2StatsText.setText(juego.getJugadorActual().getAdversario().getPokemonActual()
                .getNombre() + "\n" +
                "Lv " + juego.getJugadorActual().getAdversario().getPokemonActual().getCualidades().getNivel());
        this.pokemonJ2HP.setProgress(juego.getJugadorActual().getAdversario().getPokemonActual().getCualidades().getPorcentajeVida());

        this.pokemonJ1View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugadorActual().getPokemonActual(), "Espalda").getImage());
        this.pokemonJ1View.setFitHeight(this.pokemonJ1View.getImage().getHeight()*3);
        this.pokemonJ1View.setFitWidth(this.pokemonJ1View.getImage().getWidth()*3);
        this.pokemonJ2View.setImage(pokemonResourceFactory.createPokemonBattleView(juego.getJugadorActual().getAdversario().getPokemonActual(), "Frente").getImage());
        this.pokemonJ2View.setFitHeight(this.pokemonJ2View.getImage().getHeight()*3);
        this.pokemonJ2View.setFitWidth(this.pokemonJ2View.getImage().getWidth()*3);

        this.atacarButton.setOnAction(event -> crearMenuAtaques(juego.getJugadorActual().getPokemonActual()));
        this.itemButton.setOnAction(event -> {
            try {
                crearMenuItem(juego.getJugadorActual());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        this.pokemonButton.setOnAction(event -> this.juegoController.handle(new MenuCambiarPokemonEvent(juego.getJugadorActual())));
        this.rendirseButton.setOnAction(event -> this.juegoController.handle(new RendirseEvent(juego.getJugadorActual())));
    }

    private void crearMenuItem(Jugador jugadorActual) throws IOException {
        // Call a function from your object
        juegoController.handle(new MenuItemEvent(jugadorActual)); // Replace yourFunction with the actual function name
    }


    public void crearMenuAtaques(Pokemon pokemon) {
        GridPane ataques = new GridPane();

        List<Habilidad> habilidades = new ArrayList<>(pokemon.getMisHabilidades().values());

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Habilidad habilidad = habilidades.get(index);
                Button ataque = new Button(habilidad.getNombre());
                ataque.setPrefHeight(50);
                ataque.setPrefWidth(100);
                ataque.setOnAction(event -> this.juegoController.handle(new AtaqueSeleccionadoEvent(habilidad, pokemon)));
                ataques.add(ataque, j, i);
                index++;
            }
        }
        this.dialogoBox.getChildren().add(ataques);
    }

    public void actualizarVista(Juego juego) {
        this.dialogoBox.getChildren().clear();
        this.crearVentanaBatalla(juego);
    }

    public void mostrarMensaje(String mensaje) {
        this.dialogo.setText(mensaje);
    }
}
