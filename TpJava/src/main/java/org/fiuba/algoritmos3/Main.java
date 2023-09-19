package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Juego juego = new Juego();


        System.out.println("Pruebas de Jugador - Creacion");

        juego.getJugador1().elegirPokemon("Squirtle");
        juego.getJugador1().elegirPokemon("Ratata");
        juego.getJugador2().elegirPokemon("Charmander");

        juego.getJugador1().atacarAdversario(); // Si se corre sin añadir habilidades al pokemon salta error,



    }


}
