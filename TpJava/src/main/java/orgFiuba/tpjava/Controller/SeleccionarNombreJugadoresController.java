package orgFiuba.tpjava.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orgFiuba.tpjava.MainJavaFX;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;

import java.io.IOException;

public class SeleccionarNombreJugadoresController {

    public TextField nombreJugador;
    @FXML
    private Stage stageNombreJugador;


    private Jugador jugador;


    public void inicializador(Jugador jugador, Stage stageNombreJugador1){
        this.jugador = jugador;
        this.stageNombreJugador = stageNombreJugador1;
    }

    public void siguienteVentana(ActionEvent event) throws IOException {

        String nombre = this.nombreJugador.getText();
        System.out.println(nombre);
        if(nombre.isEmpty()){
            Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("No hay ningun caracter en el nombre.");
            alert.showAndWait();
        }
        else if(nombre.length() > 50){
            Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Hay mas de 50 caracteres en el nombre.");
            alert.showAndWait();
        }
        else{
            this.jugador.setNombre(nombre);
            this.stageNombreJugador.close();
        }


    }
}
