package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orgFiuba.tpjava.MainJavaFX;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;

import java.io.IOException;

public class InicioController {
    @FXML
    private Label welcomeText;

    @FXML
    private Stage stageInicio;

    private Juego juego;

    public void setStageInicio(Stage stageInicio) {
        this.stageInicio = stageInicio;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void crearVentanaSeleccionNombre(Jugador jugador) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainJavaFX.class.getResource("seleccionarNombreJugadores-view.fxml"));
        VBox root = fxmlLoader.load();
        SeleccionarNombreJugadoresController controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 1280, 768);
        Stage stageNombreJugador = new Stage();
        stageNombreJugador.setScene(scene);
        controller.inicializador(jugador, stageNombreJugador);
        stageNombreJugador.show();
        stageNombreJugador.setTitle("Seleccionar Nombre Jugador");
    }

    public void crearVentanaSeleccionarPokemonInicial(Jugador jugador) throws IOException {

    }

    @FXML
    protected void onHelloButtonClick() throws IOException {

        welcomeText.setText("");
        this.stageInicio.close();
        this.crearVentanaSeleccionNombre(juego.getJugador1());
        this.crearVentanaSeleccionNombre(juego.getJugador2());
        //this.crearVentanaSeleccionarPokemonInicial();

    }

    public void abrirStageInicio() {
        this.stageInicio.show();
    }
}