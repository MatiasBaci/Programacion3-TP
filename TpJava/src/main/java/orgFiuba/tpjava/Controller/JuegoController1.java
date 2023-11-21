package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import orgFiuba.tpjava.Model.Juego;

public class JuegoController1 implements EventHandler<CambioDeTurnoEvent> {

    @FXML
    public Rectangle jugador1View;
    @FXML
    public Rectangle jugador2View;

    private Juego juego;

    @FXML
    private Label jugador1;
    @FXML
    private Label jugador2;
    @FXML
    private Label jugadorActual;

    @FXML
    private Label welcomeText;

    public void setJuego(Juego juego) {
        this.juego = juego;
        this.jugador1.setText(juego.getJugador1().getNombre());
        this.jugador2.setText(juego.getJugador2().getNombre());
        this.jugadorActual.setText("Jugador Actual: " + juego.getJugadorActual().getNombre());
    }

    @Override
    public void handle(CambioDeTurnoEvent cambioDeTurnoEvent) {
        this.juego.cambiarTurno();
        this.jugadorActual.setText("Jugador Actual: " + juego.getJugadorActual().getNombre());
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
