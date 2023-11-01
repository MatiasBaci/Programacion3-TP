package org.fiuba.algoritmos3;
import view.GeneralView;
import view.JugadorView;

import java.util.Objects;
import java.util.Scanner;


public class OpcionIntercambiarPokemon implements Opciones{

    private boolean validarPokemon(Jugador jugador, JugadorView jugadorView){

        Scanner scanner = new Scanner(System.in);

        String nombrePokemon = scanner.next();
        jugadorView.mostrarCasosDeEleccion(nombrePokemon, jugador.getPokemonActual(), jugador.getMisPokemones());
        return jugador.elegirPokemon(nombrePokemon);
    }

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeIntercambiarPokemon();
        Pokemon pokemonAuxliar = jugador.getPokemonActual();
        if(validarPokemon(jugador, generalView.getJugadorView())){
            Scanner scanner = new Scanner(System.in);
            generalView.mostrarMensajeRealizarIntercambio();


            String decision = scanner.next();

            if (Objects.equals(decision.toLowerCase(), "si")) {
                generalView.mostrarMensajeIntercambioAlAdversario();
                jugador.setAtacante(false);

            } else {
                jugador.setPokemonActual(pokemonAuxliar);
                generalView.mostrarMensajeNoSeRealizoIntercambio();

            }
            decision = scanner.next();
        }
    }
}