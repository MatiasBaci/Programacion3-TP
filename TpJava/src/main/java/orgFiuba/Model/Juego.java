package orgFiuba.Model;

import orgFiuba.Model.Climas.SistemaDeClima;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.View.GeneralView;

import java.util.Scanner;

import static orgFiuba.Constantes.ANSI_RESET;
import static orgFiuba.Constantes.ANSI_VERDEOSCURO;

public class Juego {

    //Atributos:
    private Jugador jugador1;
    private Jugador jugador2;
    private Controlador controlador;
    private GeneralView generalView;

    //Metodos:

    public Juego(){

        ServicioDeUserInput.inicializarScanner();

        Datos datos = new Datos();
        this.jugador1 = new Jugador("-", datos.getMochilaJugador1(), datos.getItemsJugador1());
        this.jugador2 = new Jugador("-", datos.getMochilaJugador2(), datos.getItemsJugador2());

        this.jugador1.setAdversario(jugador2);
        this.jugador2.setAdversario(jugador1);
        this.controlador = new Controlador();

        SistemaDeClima.iniciarSistemaDeClima();
        SistemaDeClima.inicializarClimaActual();
        this.generalView = new GeneralView(jugador1, SistemaDeClima.getClimaActual());
    }

    public Juego(Scanner scanner){

        ServicioDeUserInput.setScanner(scanner);

        Datos datos = new Datos();
        this.jugador1 = new Jugador("-", datos.getMochilaJugador1(), datos.getItemsJugador1());
        this.jugador2 = new Jugador("-", datos.getMochilaJugador2(), datos.getItemsJugador2());

        this.jugador1.setAdversario(jugador2);
        this.jugador2.setAdversario(jugador1);
        this.controlador = new Controlador();

        SistemaDeClima.iniciarSistemaDeClima();
        SistemaDeClima.inicializarClimaActual();
        this.generalView = new GeneralView(jugador1, SistemaDeClima.getClimaActual());
    }

    public Juego(Jugador jugador1, Jugador jugador2, Controlador controlador, GeneralView generalView){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.controlador = controlador;
        this.generalView = generalView;
    }

    private boolean pokemonJugador1EsRapido(Pokemon pokemonJugador1, Pokemon pokemonJugador2){
        return pokemonJugador1.obtenerVelocidad() >= pokemonJugador2.obtenerVelocidad();
    }

    private void decidirTurnoInicial() {
        if (this.pokemonJugador1EsRapido(this.jugador1.getPokemonActual(), this.jugador2.getPokemonActual())) {
            this.jugador1.setAtacante(true);
            System.out.println(ANSI_VERDEOSCURO + "COMIENZA ATACANDO " + this.jugador1.getNombre().toUpperCase() + ANSI_RESET);
        } else {
            this.jugador2.setAtacante(true);
            System.out.println(ANSI_VERDEOSCURO + "COMIENZA ATACANDO " + this.jugador2.getNombre().toUpperCase() + ANSI_RESET);
        }

        System.out.println("\n");
        System.out.println(ANSI_VERDEOSCURO + "Oprima una tecla para salir: " + ANSI_RESET);
        String decision = ServicioDeUserInput.input();
        System.out.println("\n");
    }


    public void menuSeleccion() {

        this.generalView.mostrarMensajeBienvenida();
        this.controlador.validarNombresJugador(this.jugador1);
        this.controlador.validarNombresJugador(this.jugador2);
        this.generalView = new GeneralView(jugador1, SistemaDeClima.getClimaActual());
        this.generalView.getJugadorView().setJugadorAdversarioView(jugador2);
        this.controlador.seleccionarPokemon(this.jugador1, this.generalView.getJugadorView());
        this.controlador.seleccionarPokemon(this.jugador2, this.generalView.getJugadorAdversarioView());
        this.decidirTurnoInicial();
    }

    public void aplicarIteracion(Jugador jugador, Jugador jugadorAversario){

        jugador.aplicarEfectoPasivo();
        SistemaDeClima.aplicarClimaActual(jugador.getPokemonActual());
        this.generalView.modificarClimaActualView(SistemaDeClima.getClimaActual());
        this.generalView.setJugadorView(jugador);
        this.generalView.getJugadorView().setJugadorAdversarioView(jugadorAversario);
        this.generalView.getJugadorView().setPokemonActualView(jugador.getPokemonActual());
        this.generalView.getJugadorAdversarioView().setPokemonActualView(jugadorAversario.getPokemonActual());
        this.generalView.mostrarEfectoPasivo();
        this.controlador.opcionesJugadores(jugador, this.generalView);
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
            this.generalView.felicitar(this.jugador2);
        } else{
            this.generalView.felicitar(this.jugador1);
        }
    }

    public void DesarrollarJuego(){
        this.menuSeleccion();
        this.iteracionesJugadores();
    }
}
