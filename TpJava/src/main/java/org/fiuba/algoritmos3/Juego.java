package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;


public class Juego {

    //Atributos:
    private Jugador jugador1;
    private Jugador jugador2;
    private Datos datos;
    private Controlador controlador;

    private Opciones opciones;
    //Metodos:

    public Juego(){
        this.datos = new Datos();
        this.jugador1 = new Jugador("-",datos.getMochilaJugador1(),datos.getItemsJugador1());
        this.jugador2 = new Jugador("-",datos.getMochilaJugador2(),datos.getItemsJugador2());

        this.jugador1.añadirAdversario(jugador2);
        this.jugador2.añadirAdversario(jugador1);
        this.controlador = new Controlador();
    }

    private boolean pokemonJugador1EsRapido(Pokemon pokemonJugador1, Pokemon pokemonJugador2){
        return pokemonJugador1.getVelocidad() >= pokemonJugador2.getVelocidad();
    }
    
    private void decidirTurnoInicial() {
        if (this.pokemonJugador1EsRapido(this.jugador1.getPokemonActual(), this.jugador2.getPokemonActual())) {
            this.jugador1.setAtacante(true);
            System.out.println("COMIENZA ATACANDO " + this.jugador1.getNombre());
        } else {
            this.jugador2.setAtacante(true);
            System.out.println("COMIENZA ATACANDO " + this.jugador2.getNombre());
        }
    }


    public void menuSeleccion() {

        this.controlador.mensajeBienvenida();
        this.controlador.validarNombresJugador(this.jugador1);
        this.controlador.validarNombresJugador(this.jugador2);
        this.controlador.seleccionarPokemon(this.jugador1);
        this.controlador.seleccionarPokemon(this.jugador2);
        this.decidirTurnoInicial();
    }


    public void aplicarIteracion(Jugador jugador, Jugador jugadorAversario){

        jugador.aplicarEfectoPasivo();

        this.controlador.opcionesJugadores(jugador);

        jugadorAversario.setAtacante(true);
    }


    public void iteracionesJugadores() {

        while (!this.jugador1.perdio() && !this.jugador2.perdio()){
            if(this.jugador1.isAtacante()){
                this.aplicarIteracion(this.jugador1, this.jugador2);
            } else{
                this.aplicarIteracion(this.jugador2, this.jugador1);
            }
        }
        if(this.jugador1.perdio()){
            System.out.println("Gano " + this.jugador2.getNombre());
        } else{
            System.out.println("Gano " + this.jugador1.getNombre());
        }
    }

    public void DesarrollarJuego(){
        this.menuSeleccion();
        this.controlador.inicializarOpciones();
        this.iteracionesJugadores();
    }




}
