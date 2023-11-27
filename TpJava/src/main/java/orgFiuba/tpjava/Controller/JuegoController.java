package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.RUTA_SOUNDTRACK_BATALLA;
import static orgFiuba.tpjava.Constantes.RUTA_SOUNDTRACK_INICIO;

public class JuegoController extends Parent implements EventHandler<Event> {
    @FXML
    private Label welcomeText;
    @FXML
    private Stage stage;
    private Juego juego;
    @FXML
    private MediaPlayer musicPlayer;
    @FXML
    private MediaPlayer soundEffectPlayer;
    private Map<String, Scene> escenas;
    private BatallaController batallaController;

    public void inicializar(Stage stage, Juego juego) throws IOException {
        this.stage = stage;
        this.juego = juego;
        this.inicializarEscenas();
        this.reproducirMusica(RUTA_SOUNDTRACK_INICIO);
        this.stage.show();
    }


    private void inicializarEscenas() throws IOException {
        SceneFactory sceneFactory = new SceneFactory();
        this.escenas = sceneFactory.createScenesIniciales(this.juego, this);
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("");
        this.crearVentanaSeleccionNombre(juego.getJugador1(), 1);
    }

    @Override
    public void handle(Event event) {
        if (event instanceof JugadorNombradoEvent) {
            this.handle((JugadorNombradoEvent) event);
        } else if (event instanceof PokemonSeleccionadoEvent) {
            this.handle((PokemonSeleccionadoEvent) event);
        }
    }

    public void handle(JugadorNombradoEvent jugadorNombradoEvent) {

        if (this.juego.getJugador2().getNombre().isBlank()) {
            try {
                System.out.println("Jugador 2");
                this.crearVentanaSeleccionNombre(juego.getJugador2(), 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                this.crearVentanaSeleccionarPokemonInicial(this.juego.getJugador1(), 1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handle(PokemonSeleccionadoEvent pokemonSeleccionadoEvent) {

        pokemonSeleccionadoEvent.getJugador().setPokemonActual(pokemonSeleccionadoEvent.getPokemon());

        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();
        reproducirSoundEffect(pokemonResourceFactory.createPokemonCryPath(pokemonSeleccionadoEvent.getPokemon()));

        if (this.juego.getJugador2().getPokemonActual() == null) {
            try {
                this.crearVentanaSeleccionarPokemonInicial(juego.getJugador2(), 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Continúa a la ventana de Juego");
            this.elegirJugadorInicial();
            this.crearVentanaBatalla();
        }
    }

    private void elegirJugadorInicial() {
        if (this.juego.getJugador1().getPokemonActual().getCualidades().getVelocidad() > this.juego.getJugador2().getPokemonActual().getCualidades().getVelocidad()) {
            this.juego.getJugador1().setAtacante(true);
            this.juego.getJugador2().setAtacante(false);
            this.juego.setJugadorActual(this.juego.getJugador1());
        } else {
            this.juego.getJugador1().setAtacante(false);
            this.juego.getJugador2().setAtacante(true);
            this.juego.setJugadorActual(this.juego.getJugador2());
        }
    }

    public void handle(AtaqueSeleccionadoEvent ataqueSeleccionadoEvent) {
        this.juego.getJugadorActual().atacarJugador(this.juego.getJugadorActual().getAdversario(), ataqueSeleccionadoEvent.getHabilidad().getNombre());
        this.juego.cambiarTurno();
        this.batallaController.actualizarVista(this.juego);
    }

    private void crearVentanaBatalla() {

            this.reproducirMusica(RUTA_SOUNDTRACK_BATALLA);

            SceneFactory sceneFactory = new SceneFactory();
            try {
                this.escenas.put("sceneBatalla", sceneFactory.crearEscenaBatalla(this.juego, this));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.stage.setScene(this.escenas.get("sceneBatalla"));
            this.stage.setTitle("Batalla Pokemon");
            this.stage.show();
    }

    public void crearVentanaSeleccionNombre(Jugador jugador, int numero) throws IOException {

        this.stage.setScene(this.escenas.get("sceneSeleccionNombreJugador" + numero));
        this.stage.setTitle("Escriba el Nombre del Jugador " + numero);
        this.stage.show();
    }

    public void crearVentanaSeleccionarPokemonInicial(Jugador jugador, int numero) throws IOException {

        try {
            this.stage.setScene(this.escenas.get("sceneSeleccionPokemonInicialJugador" + numero));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        this.stage.setTitle("Seleccion de Pokemon Inicial Jugador " + numero);
        this.stage.show();
    }

    public void reproducirMusica(String ruta) {
        try {
            this.musicPlayer.stop();
        } catch (Exception e) {}
        this.musicPlayer = new MediaPlayer(new Media(new File(ruta).toURI().toString()));
        this.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.musicPlayer.setVolume(0.2);
        this.musicPlayer.play();
    }

    public void reproducirSoundEffect(String ruta) {
        try {
            this.soundEffectPlayer.stop();
        } catch (Exception e) {}
        this.soundEffectPlayer = new MediaPlayer(new Media(new File(ruta).toURI().toString()));
        this.soundEffectPlayer.setCycleCount(1);
        this.soundEffectPlayer.setVolume(0.2);
        this.soundEffectPlayer.play();
    }

    public void setBatallaController(BatallaController batallaController) {
        this.batallaController = batallaController;
    }
}