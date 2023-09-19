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
        jugador1 = new Jugador("Ash",datos.getMochilaDePokemonAsh(),datos.getItemsDeAsh());
        jugador2 = new Jugador("Mario",datos.getMochilaDePokemonMario(),datos.getItemsDeAsh());

        jugador1.añadirAdversario(jugador2);
        jugador2.añadirAdversario(jugador1);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }


}
