package org.fiuba.algoritmos3;

import org.fiuba.algoritmos3.Jugador;

import java.util.Objects;
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

        Scanner scanner = new Scanner(System.in);
        this.mensajeAtacarPokemon();
        jugador.mostratHabilidadesPokemonActual();
        System.out.println("Elige una habilidad del Pokemon: ");
        String opcion = scanner.next();
        System.out.println("Desea usar la habilidad? Si - No");
        String decision = scanner.next();
        if(Objects.equals(decision, "Si")){
            jugador.atacarJugador(jugadorAdversario, opcion);
        }else{
            System.out.println("No utilizo la habilidad.");
        }



    }
}
