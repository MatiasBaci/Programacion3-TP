package orgFiuba.tpjava.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import orgFiuba.tpjava.MainJavaFX;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.RUTA_SOUNDTRACK_INICIO;

public class JuegoController extends Parent implements EventHandler<Event> {
    @FXML
    private Label welcomeText;

    @FXML
    private Stage stage;
    private Juego juego;
    @FXML
    //private MediaPlayer mediaPlayer;
    private Map<String, Scene> escenas;

    public void inicializar(Stage stage, Juego juego) throws IOException {
        this.stage = stage;
        this.juego = juego;

       // Media media = new Media(new File(RUTA_SOUNDTRACK_INICIO).toURI().toString());
       // this.mediaPlayer = new MediaPlayer(media);
        //this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //this.mediaPlayer.setVolume(0.2);
       // this.mediaPlayer.play();

        this.stage.show();

        this.inicializarEscenas();
    }

    private void inicializarEscenas() throws IOException {

        SceneFactory sceneFactory = new SceneFactory();
        this.escenas = sceneFactory.createScenes(this.juego, this);
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
                System.out.println("osdamndasdsadpasdasod");
                this.crearVentanaSeleccionarPokemonInicial(this.juego.getJugador1(), 1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handle(PokemonSeleccionadoEvent pokemonSeleccionadoEvent) {

        if (this.juego.getJugador2().getNombrePokemonActual().isBlank()){
            try{
                System.out.println(juego.getJugador2().getNombre());
                System.out.println("DFSDFSFD");
                this.crearVentanaSeleccionarPokemonInicial(juego.getJugador2(), 2);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }else{
            //this.crearVentanaMenu(this.juego.getJugador1(), 1);
            System.out.println("Se metio");
        }
    }

    public void crearVentanaSeleccionNombre(Jugador jugador, int numero) throws IOException {

        this.stage.setScene(this.escenas.get("sceneSeleccionNombreJugador" + numero));
        this.stage.setTitle("Escriba el Nombre del Jugador " + numero);
        this.stage.show();
    }

    public void crearVentanaSeleccionarPokemonInicial(Jugador jugador, int numero) throws IOException {

        this.stage.setScene(this.escenas.get("sceneSeleccionPokemonInicialJugador" + numero));
        this.stage.setTitle("Seleccion de Pokemon Inicial Jugador " + numero);
        this.stage.show();
    }

    public void start2(Stage primaryStage) {
        // Escena 1
        StackPane layout1 = new StackPane();
        Scene scene1 = new Scene(layout1, 300, 200);
        Button button1 = new Button("Ir a Escena 2");
        StackPane layout2 = new StackPane();

        Scene scene2 = new Scene(layout2, 300, 200);

        button1.setOnAction(e -> primaryStage.setScene(scene2));
        layout1.getChildren().add(button1);

        // Escena 2
        Button button2 = new Button("Ir a Escena 1");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        layout2.getChildren().add(button2);

        // Configurar la Stage
        primaryStage.setTitle("App con Múltiples Escenas");
        primaryStage.setScene(scene1);

        // Mostrar la Stage
        primaryStage.show();
    }


}