package orgFiuba.tpjava.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.MainJavaFX;
import orgFiuba.tpjava.Model.Juego;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneFactory {

    public Map<String, Scene> createScenesIniciales(Juego juego, JuegoController juegoController) throws IOException {

        Map escenas = new HashMap<>();

        FXMLLoader fxmlLoaderJ1 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarNombreJugadores-view.fxml"));
        VBox seleccionarNombresLoaderJugador1 = fxmlLoaderJ1.load();
        SeleccionarNombreJugadoresController nombreJugador1Controller = fxmlLoaderJ1.getController();
        nombreJugador1Controller.inicializador(juego.getJugador1(), juegoController);
        Scene sceneSeleccionNombreJugador1 = new Scene(seleccionarNombresLoaderJugador1, 1024, 768);
        escenas.put("sceneSeleccionNombreJugador1", sceneSeleccionNombreJugador1);

        FXMLLoader fxmlLoaderJ2 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarNombreJugadores-view.fxml"));
        VBox seleccionarNombresLoaderJugador2 = fxmlLoaderJ2.load();
        SeleccionarNombreJugadoresController nombreJugador2Controller = fxmlLoaderJ2.getController();
        nombreJugador2Controller.inicializador(juego.getJugador2(), juegoController);
        Scene sceneSeleccionNombreJugador2 = new Scene(seleccionarNombresLoaderJugador2, 1024, 768);
        escenas.put("sceneSeleccionNombreJugador2", sceneSeleccionNombreJugador2);

        FXMLLoader fxmlLoaderP1 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarPokemon-view.fxml"));
        GridPane seleccionarPokemonLoaderJugador1 = fxmlLoaderP1.load();
        SeleccionarPokemonController seleccionarPokemonControllerJugador1 = fxmlLoaderP1.getController();
        seleccionarPokemonControllerJugador1.inicializar(juego.getJugador1(), juegoController);
        Scene sceneSeleccionPokemonJugador1 = new Scene(seleccionarPokemonLoaderJugador1, 1024, 768);
        escenas.put("sceneSeleccionPokemonInicialJugador1", sceneSeleccionPokemonJugador1);

        FXMLLoader fxmlLoaderP2 = new FXMLLoader(MainJavaFX.class.getResource("seleccionarPokemon-view.fxml"));
        GridPane seleccionarPokemonLoaderJugador2 = fxmlLoaderP2.load();
        SeleccionarPokemonController seleccionarPokemonControllerJugador2 = fxmlLoaderP2.getController();
        seleccionarPokemonControllerJugador2.inicializar(juego.getJugador2(), juegoController);
        Scene sceneSeleccionPokemonJugador2 = new Scene(seleccionarPokemonLoaderJugador2, 1024, 768);
        escenas.put("sceneSeleccionPokemonInicialJugador2", sceneSeleccionPokemonJugador2);

        FXMLLoader fxmlLoaderItemP1 = new FXMLLoader(MainJavaFX.class.getResource("aplicarItem-view.fxml"));
        GridPane aplicarItemLoaderJugador1 = fxmlLoaderItemP1.load();
        AplicarItemController aplicarItemControllerJugador1 = fxmlLoaderItemP1.getController();
        aplicarItemControllerJugador1.inicializar(juego.getJugador1(), juegoController);
        Scene sceneAplicarItemJugador1 = new Scene(aplicarItemLoaderJugador1, 1024, 768);
        escenas.put("sceneAplicarItemJugador1", sceneAplicarItemJugador1);

        return escenas;
    }

    public Scene crearEscenaBatalla(Juego juego, JuegoController juegoController) throws IOException {
        FXMLLoader fxmlLoaderBatalla = new FXMLLoader(MainJavaFX.class.getResource("batalla-view.fxml"));
        AnchorPane batallaLoader = fxmlLoaderBatalla.load();
        BatallaController batallaController = fxmlLoaderBatalla.getController();
        batallaController.inicializar(juego, juegoController);
        Scene sceneBatalla = new Scene(batallaLoader, 1024, 768);
        return sceneBatalla;
    }
}
