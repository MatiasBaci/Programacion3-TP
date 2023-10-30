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
            System.out.println("Desea Realizar el cambio? Si - No");

            String decision = scanner.next();

            if (Objects.equals(decision, "Si")) {
                generalView.mostrarMensajeIntercambioAlAdversario();
                jugador.setAtacante(false);
                System.out.println("Es el turno del otro jugador. Oprima una tecla para continuar.");

            } else {
                jugador.setPokemonActual(pokemonAuxliar);
                System.out.println("No se realizo el intercambio. Oprima una tecla para continuar.");

            }
            decision = scanner.next();
        }
    }
}