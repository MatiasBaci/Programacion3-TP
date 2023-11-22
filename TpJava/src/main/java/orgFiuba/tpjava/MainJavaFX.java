package orgFiuba.tpjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orgFiuba.tpjava.Controller.JuegoController;
import orgFiuba.tpjava.Model.Juego;

import java.io.IOException;

public class MainJavaFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Juego juego = new Juego();
        //juego.DesarrollarJuego();

        FXMLLoader fxmlLoader = new FXMLLoader(MainJavaFX.class.getResource("juego-view.fxml"));
        VBox root = fxmlLoader.load();
        JuegoController juegoController = fxmlLoader.getController();
        juegoController.setJuego(juego);

        Scene scene = new Scene(root, 1280, 768);
        stage.setTitle("Batalla Pokémon");

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}