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
        this.datos = new Datos();
        this.jugador1 = new Jugador("-",datos.getMochilaJugador1(),datos.getItemsJugador1());
        this.jugador2 = new Jugador("-",datos.getMochilaJugador2(),datos.getItemsJugador2());

        this.jugador1.añadirAdversario(jugador2);
        this.jugador2.añadirAdversario(jugador1);
        this.controlador = new Controlador();
    }

    public void inicializarJuego(){
        System.out.println("Pruebas de Jugador - Creacion");

        jugador1.elegirPokemon("Squirtle");
        jugador1.elegirPokemon("Ratata");
        jugador2.elegirPokemon("Charmander");

        //jugador1.atacarAdversario(); // Si se corre sin añadir habilidades al pokemon salta error,
    }

    private boolean pokemonJugador1EsRapido(Pokemon pokemonJugador1, Pokemon pokemonJugador2){
        return pokemonJugador1.getVelocidad() >= pokemonJugador2.getVelocidad();
    }
    
    private void decidirTurnoInicial() {
        if (this.pokemonJugador1EsRapido(jugador1.getPokemonActual(), jugador2.getPokemonActual())) {
            jugador1.setAtacante(true);
            System.out.println("Comienza atacando " + jugador1.getNombre());
        } else {
            jugador2.setAtacante(true);
            System.out.println("Comienza atacando " + jugador2.getNombre());
        }
    }


    public void menuSeleccion() {

        controlador.mensajeBienvenida();
        controlador.validarNombresJugador(this.jugador1);
        controlador.validarNombresJugador(this.jugador2);
        controlador.seleccionarPokemon(this.jugador1);
        controlador.seleccionarPokemon(this.jugador2);
        this.decidirTurnoInicial();
    }


    public void aplicarIteracion(Jugador jugador, Jugador jugadorAversario){

        System.out.println("Es el turno de " + jugador.getNombre());

        jugador.aplicarEfectoPasivo();
        controlador.opcionesJugadores(jugador);

        jugadorAversario.setAtacante(true);
    }


    public void iteracionesJugadores() {

        while (!this.jugador1.isGanoJuego() && !this.jugador2.isGanoJuego()){
            if(this.jugador1.isAtacante()){
                this.aplicarIteracion(this.jugador1, this.jugador2);
            } else{
                this.aplicarIteracion(this.jugador2, this.jugador1);
            }
        }
    }

    public void DesarrollarJuego(){
        this.menuSeleccion();
        this.iteracionesJugadores();
    }




}
