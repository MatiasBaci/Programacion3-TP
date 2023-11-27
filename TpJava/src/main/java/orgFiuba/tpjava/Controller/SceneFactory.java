package orgFiuba.tpjava.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

        FXMLLoader fxmlLoaderP = new FXMLLoader(MainJavaFX.class.getResource("seleccionarPokemon-view.fxml"));
        GridPane seleccionarPokemonLoaderJugador = fxmlLoaderP.load();
        SeleccionarPokemonController seleccionarPokemonControllerJugador = fxmlLoaderP.getController();
        seleccionarPokemonControllerJugador.inicializar(juego.getJugadorActual(), juegoController);
        Scene sceneSeleccionPokemonJugador = new Scene(seleccionarPokemonLoaderJugador, 1024, 768);
        escenas.put("sceneSeleccionPokemon", sceneSeleccionPokemonJugador);

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
        VBox batallaLoader = fxmlLoaderBatalla.load();
        BatallaController batallaController = fxmlLoaderBatalla.getController();
        batallaController.inicializar(juego, juegoController);
        return new Scene(batallaLoader, 1024, 768);
    }
}
