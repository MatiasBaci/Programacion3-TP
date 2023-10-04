package Opciones;

import org.fiuba.algoritmos3.Jugador;

import java.util.Scanner;

public class Atacar implements Opciones{


    private void mensajeAtacarPokemon() {
        System.out.println("\n");
        System.out.println("╔════════════════╗");
        System.out.println("║ Atacar Pokemon ║");
        System.out.println("╚════════════════╝");
        System.out.println("\n");
    }
    @Override
    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario){

        this.mensajeAtacarPokemon();
        jugador.mostratHabilidadesPokemonActual();
        System.out.println("Elige una habilidad: ");
        Scanner scanner = new Scanner(System.in);
        String opcion;
        opcion = scanner.next();

        jugador.atacarJugador(jugadorAdversario, opcion);


    }
}
