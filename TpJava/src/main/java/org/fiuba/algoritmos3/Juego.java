package org.fiuba.algoritmos3;
/* import java.util.ArrayList;
import java.util.List; */
public class Juego {

    //Atributos:
    private Jugador jugador1;
    private Jugador jugador2;
    private Datos datos;
    private Controlador controlador;

    //Metodos:

    public Juego(){
        datos = new Datos();
        jugador1 = new Jugador("-",datos.getMochilaJugador1(),datos.getItemsJugador1());
        jugador2 = new Jugador("-",datos.getMochilaJugador2(),datos.getItemsJugador1());

        jugador1.añadirAdversario(jugador2);
        jugador2.añadirAdversario(jugador1);
        controlador = new Controlador();
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

        //jugador1.atacarAdversario(); // Si se corre sin añadir habilidades al pokemon salta error,
    }


    private boolean CompararPokemonesIniciales(Pokemon pokemonJugador1, Pokemon pokemonJugador2){

        boolean jugador1MayorVelocidad;
        jugador1MayorVelocidad = (pokemonJugador1.getVelocidad() >= pokemonJugador2.getVelocidad());
        return jugador1MayorVelocidad;
    }

    
    private void decidirTurnoInicial() {
        if (CompararPokemonesIniciales(jugador1.getPokemonActual(), jugador2.getPokemonActual())) {
            jugador1.setAtacante(true);
            System.out.println("Comienza atacando " + jugador1.getNombre());
        } else {
            jugador2.setAtacante(true);
            System.out.println("Comienza atacando " + jugador2.getNombre());
        }
    }


    public void menuSeleccion(Jugador jugador1, Jugador jugador2) {

        controlador.mensajeBienvenida();
        controlador.validarNombresJugador(this.jugador1);
        controlador.validarNombresJugador(this.jugador2);
        controlador.seleccionarPokemon(this.jugador1);
        controlador.seleccionarPokemon(this.jugador2);
        decidirTurnoInicial();
    }


    public void aplicarIteracion(Jugador jugador, Jugador jugadorAversario){

        System.out.println("Es el turno de " + jugador.getNombre());
        controlador.opcionesJugadores(jugador);
        jugador.aplicarEfectoPasivo();
        jugadorAversario.setAtacante(true);
    }


    public void iteracionesJugadores() {

        while (!jugador1.isGanoJuego() && !jugador2.isGanoJuego()){

            if(jugador1.isAtacante()){
                aplicarIteracion(jugador1, jugador2);
            } else{
                aplicarIteracion(jugador2, jugador1);
            }
        }
    }


    public void DesarrollarJuego(){
        menuSeleccion(jugador1, jugador2);
        iteracionesJugadores();
    }




}
