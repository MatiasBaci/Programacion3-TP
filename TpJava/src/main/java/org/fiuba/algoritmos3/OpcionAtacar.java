package org.fiuba.algoritmos3;

import view.GeneralView;
import view.JugadorView;

import java.util.Scanner;

public class OpcionAtacar implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeAtacarPokemon();
        Scanner scanner = new Scanner(System.in);
        String opcion;
        opcion = scanner.next();

        jugador.atacarJugador(jugador.getAdversario(), opcion);


    }
}
