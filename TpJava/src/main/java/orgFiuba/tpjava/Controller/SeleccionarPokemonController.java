package orgFiuba.tpjava.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import orgFiuba.tpjava.Model.Jugador;

import java.io.IOException;

public class SeleccionarPokemonController {

    private Jugador jugador;

    private JuegoController juegoController;

    public void inicializador(Jugador jugador, JuegoController juegoController){
        this.jugador = jugador;
        this.juegoController = juegoController;
    }

    public void elegirPokemon(ActionEvent event) throws IOException {

        this.juegoController.handle(new PokemonSeleccionadoEvent());

    }
}
