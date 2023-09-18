package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Datos datos = new Datos();

        Map<String, Pokemon> mochilaDePokemonAsh = new HashMap<>();
        Map<String, Pokemon> mochilaDePokemonMario = new HashMap<>();
        List<Items> itemsDeAsh = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon("Squirtle",5,"Agua","Es un pokemon de Agua",100,15,20,20);
        Pokemon pokemon2 = new Pokemon("Charmander",5,"Fuego","Es un pokemon de Fuego",100,20,25,25);

        pokemon1.añadirHabilidad("ChorroDeAgua","Agua");

        mochilaDePokemonAsh.put(pokemon1.getNombre(), pokemon1);
        mochilaDePokemonMario.put(pokemon2.getNombre(), pokemon2);

        Jugador jugador1 = new Jugador("Ash",mochilaDePokemonAsh,itemsDeAsh);
        Jugador jugador2 = new Jugador("Mario",mochilaDePokemonMario,itemsDeAsh);

        jugador1.añadirAdversario(jugador2);
        jugador2.añadirAdversario(jugador1);

        System.out.println("Pruebas de Jugador - Creacion");

        jugador1.elegirPokemon("Squirtle");
        jugador1.elegirPokemon("Ratata");
        jugador2.elegirPokemon("Charmander");

        jugador1.atacarAdversario(); // Si se corre sin añadir habilidades al pokemon salta error,



    }


}
