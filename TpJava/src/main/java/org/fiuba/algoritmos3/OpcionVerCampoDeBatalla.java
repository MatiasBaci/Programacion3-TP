package org.fiuba.algoritmos3;

import java.util.Scanner;

public class OpcionVerCampoDeBatalla implements Opciones{

    private void mensajeCampoBatalla() {
        System.out.println("\n");
        System.out.println("╔══════════════════╗");
        System.out.println("║ Campo de Batalla ║");
        System.out.println("╚══════════════════╝");
        System.out.println("\n");
    }
    @Override
    public void aplicarOpcion(Jugador jugador){

        this.mensajeCampoBatalla();
        Scanner scanner = new Scanner(System.in);
        jugador.mostrarPokemonActual();
        jugador.getAdversario().mostrarPokemonActual();
        System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");
        scanner.next();
    }
}
