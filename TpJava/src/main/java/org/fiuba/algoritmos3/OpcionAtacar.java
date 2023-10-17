package org.fiuba.algoritmos3;

import java.util.Scanner;

public class OpcionAtacar implements Opciones{


    private void mensajeAtacarPokemon() {
        System.out.println("\n");
        System.out.println("╔════════════════╗");
        System.out.println("║ Atacar Pokemon ║");
        System.out.println("╚════════════════╝");
        System.out.println("\n");
    }
    @Override
    public void aplicarOpcion(Jugador jugador){

        this.mensajeAtacarPokemon();
        jugador.mostratHabilidadesPokemonActual();
        System.out.println("Elige una habilidad: ");
        Scanner scanner = new Scanner(System.in);
        String opcion;
        opcion = scanner.next();

        jugador.atacarJugador(jugador.getAdversario(), opcion);


    }
}
