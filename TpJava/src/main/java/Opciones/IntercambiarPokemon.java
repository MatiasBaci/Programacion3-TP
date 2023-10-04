package Opciones;

import org.fiuba.algoritmos3.Controlador;
import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.Pokemon;

import java.util.Scanner;

public class IntercambiarPokemon implements Opciones{

    private Controlador controlador;
    public IntercambiarPokemon(){
        this.controlador = new Controlador();
    }

    private void mensajeIntercambiarPokemon() {
        System.out.println("\n");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Intercambiar Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("\n");
    }

    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario){

            this.mensajeIntercambiarPokemon();
            Pokemon pokemonAuxliar = jugador.getPokemonActual();
            this.controlador.seleccionarPokemon(jugador);
            System.out.println("Desea Realizar el cambio? Si - No");
            Scanner scanner = new Scanner(System.in);
            String decision = scanner.next();
            jugador.intercambiarPokemon(decision, pokemonAuxliar);

    }
}
