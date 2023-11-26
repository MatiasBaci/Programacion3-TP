package orgFiuba.tpjava.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.MainJavaFX;
import orgFiuba.tpjava.Model.Juego;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneFactory {

    public Map<String, Scene> createScenes(Juego juego, JuegoController juegoController) throws IOException {

        Map escenas = new HashMap<>();

        FXMLLoader fxmlLoaderJ1 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarNombreJugadores-view.fxml"));
        VBox seleccionarNombresLoaderJugador1 = fxmlLoaderJ1.load();
        SeleccionarNombreJugadoresController nombreJugador1Controller = fxmlLoaderJ1.getController();
        nombreJugador1Controller.inicializador(juego.getJugador1(), juegoController);
        Scene sceneSeleccionNombreJugador1 = new Scene(seleccionarNombresLoaderJugador1, 1280, 768);
        escenas.put("sceneSeleccionNombreJugador1", sceneSeleccionNombreJugador1);

        FXMLLoader fxmlLoaderJ2 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarNombreJugadores-view.fxml"));
        VBox seleccionarNombresLoaderJugador2 = fxmlLoaderJ2.load();
        SeleccionarNombreJugadoresController nombreJugador2Controller = fxmlLoaderJ2.getController();
        nombreJugador2Controller.inicializador(juego.getJugador2(), juegoController);
        Scene sceneSeleccionNombreJugador2 = new Scene(seleccionarNombresLoaderJugador2, 1280, 768);
        escenas.put("sceneSeleccionNombreJugador2", sceneSeleccionNombreJugador2);

        /*FXMLLoader fxmlLoaderP1 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarPokemon-view.fxml"));
        VBox seleccionarPokemonLoaderJugador1 = fxmlLoaderP1.load();
        SeleccionarPokemonController seleccionarPokemonControllerJugador1 = fxmlLoaderP1.getController();



        Scene sceneSeleccionPokemonJugador1 = new Scene(new StackPane(), 1280, 768);
        Scene sceneSeleccionPokemonJugador2 = new Scene(new StackPane(), 1280, 768);
        Scene seleccionarItem = new Scene(new StackPane(), 1280, 768);
        Scene sceneJuego = new Scene(new StackPane(), 1280, 768);

        escenas.add(sceneSeleccionPokemonJugador1);
        escenas.add(sceneSeleccionPokemonJugador2);
        escenas.add(seleccionarItem);
        escenas.add(sceneJuego);*/

        return escenas;
    }
}
