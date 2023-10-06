package org.fiuba.algoritmos3;
import java.util.Scanner;


public class IntercambiarPokemon implements Opciones{

    private void mensajeIntercambiarPokemon() {

        System.out.println("\n");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Intercambiar Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("\n");
    }
    private boolean validarPokemon(Jugador jugador){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
        jugador.mostrarPokemones();
        System.out.println("Ingrese el nombre del pokemon: ");
        String nombrepokemon = scanner.next();
        return jugador.elegirPokemon(nombrepokemon);
    }

    @Override
    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario){
        this.mensajeIntercambiarPokemon();

        Pokemon pokemonAuxliar = jugador.getPokemonActual();
        if(validarPokemon(jugador)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Desea Realizar el cambio? Si - No");
        
            String decision = scanner.next();

            jugador.intercambiarPokemon(decision, pokemonAuxliar);
            decision = scanner.next();
        }
    }
}
