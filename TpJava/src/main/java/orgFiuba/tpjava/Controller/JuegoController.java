package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Juego;

public class JuegoController {
    @FXML
    private Label welcomeText;
    @FXML
    public Rectangle jugador1View;
    @FXML
    public Rectangle jugador2View;

    private Juego juego;

    @FXML
    private Label jugador1Nombre;
    @FXML
    private Label jugador2Nombre;
    @FXML
    private Text jugadorActualNombre;
    @FXML
    private ImageView pokemonJugador1;
    @FXML
    private ImageView pokemonJugador2;

    private StackPane[][] posiciones = null;

    @FXML
    private ImageView pokemonJ1ImageView;
    @FXML
    private ImageView pokemonJ2ImageView;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
        this.juego.cambiarTurno();
    }

    @FXML
    protected void handleMouseClicked(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();

    }

    public void setJuego(Juego juego) {
        this.juego = juego;
        this.jugadorActualNombre = new Text();
        this.juego.getJugador1().elegirPokemon("Pikachu");
        this.juego.getJugador2().elegirPokemon("Bidoof");
        this.juego.logicaDeTurnoSegunVelocidad();

        this.jugadorActualNombre.setText("Jugador Actual: " + juego.getJugadorActual().getNombre());

        PokemonImageFactory pokemonImageFactory = new PokemonImageFactory();

        ImageView pokemonJugador1ImageView = pokemonImageFactory.createPokemonImageView(this.juego.getJugador1().getPokemon("Pikachu"), "Frente");
        this.pokemonJugador1 = new ImageView();
        this.pokemonJugador1.setImage(pokemonJugador1ImageView.getImage());

        ImageView pokemonJugador2ImageView = pokemonImageFactory.createPokemonImageView(this.juego.getJugador2().getPokemon("Bidoof"), "Espalda");
        this.pokemonJugador2 = new ImageView();
        this.pokemonJugador2.setImage(pokemonJugador2ImageView.getImage());

        this.pokemonJ1ImageView.setImage(pokemonJugador1.getImage());
        this.pokemonJ2ImageView.setImage(pokemonJugador2.getImage());
    }
}