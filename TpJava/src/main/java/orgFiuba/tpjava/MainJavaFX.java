package orgFiuba.tpjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orgFiuba.tpjava.Model.Juego;

import java.io.IOException;

public class MainJavaFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Juego juego = new Juego();
        //juego.DesarrollarJuego();

        FXMLLoader fxmlLoader = new FXMLLoader(MainJavaFX.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();
        //JuegoController1 juegoController = fxmlLoader.getController();
        //juegoController.setJuego(juego);
        Scene scene = new Scene(root, 1280, 768);
        stage.setTitle("Batalla Pokémon");

        stage.setScene(scene);
        stage.show();

        //Image imagePikachu = new Image(getClass().getResource("/orgFiuba/tpjava/Imagenes/pokemonesEjemplo/Frente/pikachu.png").toString());
        //ImageView imageView = new ImageView();
        //imageView.setImage(imagePikachu);


        /*PokemonImageFactory pokemonImageFactory = new PokemonImageFactory();
        Pokemon pikachu = new Pokemon("Pikachu", 50, "Electrico", "Las bolsas de las mejillas están llenas de electricidad, que libera cuando se siente amenazado.",
                110, 110, 70, 75);
        pokemonImageFactory.createPokemonImageView(pikachu);
        JuegoController1 juegoController = fxmlLoader.getController();
        //juegoController.setPokemonImageFactory(pokemonImageFactory);*/
    }


    public static void main(String[] args) {
        launch();
    }
}