package org.fiuba.algoritmos3;
import org.fiuba.algoritmos3.Jugador;

import java.util.Scanner;

public class VerCampoDeBatalla implements Opciones{


    private void mensajeCampoBatalla() {
        System.out.println("\n");
        System.out.println("╔══════════════════╗");
        System.out.println("║ Campo de Batalla ║");
        System.out.println("╚══════════════════╝");
        System.out.println("\n");
    }
    @Override
    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario){

        this.mensajeCampoBatalla();
        Scanner scanner = new Scanner(System.in);
        jugador.mostrarPokemonActual();
        jugadorAdversario.mostrarPokemonActual();
        System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");
        scanner.next();
    }
}
