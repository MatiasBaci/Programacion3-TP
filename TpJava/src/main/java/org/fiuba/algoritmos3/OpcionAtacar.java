package org.fiuba.algoritmos3;

import view.GeneralView;
import view.JugadorView;

import java.util.Scanner;

public class OpcionAtacar implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeAtacarPokemon();
        Scanner scanner = new Scanner(System.in);
        String nombreHabilidad;
        nombreHabilidad = scanner.next();


        if(!jugador.validarHabilidadPokemon(nombreHabilidad)) {
            JugadorView.mostrarHabilidadNoExiste();
            return;
        }
        jugador.atacarJugador(jugador.getAdversario(), nombreHabilidad);
        generalView.mostrarCasoAtques(jugador.getPokemonActual(), jugador.getAdversario(), nombreHabilidad);


    }
}
