package Opciones;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.ServicioDeUserInput;
import view.GeneralView;

import java.util.Scanner;

public class OpcionVerCampoDeBatalla implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeCampoBatalla();
        ServicioDeUserInput.input();
    }
}
