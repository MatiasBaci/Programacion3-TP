package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.List;
public class Juego {

    //Atributos:
    private Jugador jugador1;
    private Jugador jugador2;
    private Controlador controlador;

    private Datos datos;

    //Metodos:

    public Juego(){
        Datos datos = new Datos();
        jugador1 = new Jugador("Ash",datos.getMochilaJugador1(),datos.getItemsJugador1());
        jugador2 = new Jugador("Mario",datos.getMochilaJugador2(),datos.getItemsJugador1());

        jugador1.añadirAdversario(jugador2);
        jugador2.añadirAdversario(jugador1);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    public void inicializarJuego(){
        System.out.println("Pruebas de Jugador - Creacion");

        jugador1.elegirPokemon("Squirtle");
        jugador1.elegirPokemon("Ratata");
        jugador2.elegirPokemon("Charmander");

        jugador1.atacarAdversario(); // Si se corre sin añadir habilidades al pokemon salta error,
    }


}
