package orgFiuba.tpjava.Controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import orgFiuba.tpjava.Model.Jugador;

public class SeleccionarPokemonController {

    private Jugador jugador;

    @FXML
    private Stage stageSeleccionarPokemon;

    public void inicializador(Jugador jugador, Stage stageSeleccionarPokemon){
        this.jugador = jugador;
        this.stageSeleccionarPokemon = stageSeleccionarPokemon;
    }

    public void elegirPokemon(){


    }
}
