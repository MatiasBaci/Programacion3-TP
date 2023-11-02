package Opciones;

import org.fiuba.algoritmos3.Jugador;
import view.GeneralView;

import java.util.Scanner;

public class OpcionVerCampoDeBatalla implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeCampoBatalla();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
