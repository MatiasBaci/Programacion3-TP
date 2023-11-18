package orgFiuba.Model.Opciones;

import orgFiuba.Model.Jugador;
import orgFiuba.Model.ServicioDeUserInput;
import orgFiuba.View.GeneralView;

import java.util.Scanner;

public class OpcionVerCampoDeBatalla implements Opcion{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeCampoBatalla();
        ServicioDeUserInput.input();
    }
}
