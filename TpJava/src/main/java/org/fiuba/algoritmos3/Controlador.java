package org.fiuba.algoritmos3;

import view.GeneralView;
import view.JugadorView;

import java.util.*;
import static org.fiuba.algoritmos3.Constantes.*;

public class Controlador {

    Map<String, Opciones> opciones;

    //Metodos:

    public void inicializarOpciones(){

        opciones = new HashMap<>();
        opciones.put(OPCION_UNO, new OpcionRendirse());
        opciones.put(OPCION_DOS, new OpcionVerCampoDeBatalla());
        opciones.put(OPCION_TRES, new OpcionIntercambiarPokemon());
        opciones.put(OPCION_CUATRO, new OpcionAplicarItem());
        opciones.put(OPCION_CINCO, new OpcionAtacar());
    }

    private void mensajeNombreJugador() {
        System.out.println("\n");
        System.out.println("╔════════════════════╗");
        System.out.println("║ Eleccion de nombre ║ ");
        System.out.println("╚════════════════════╝");
        System.out.println("\n");
    }

    public void validarNombresJugador(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        boolean nombreValido = false;

        while (!nombreValido) {
            mensajeNombreJugador();
            System.out.println("Ingrese el nombre del jugador: ");
            String nombreJugador = scanner.next();

            if (nombreJugador.length() < 50) {
                mensajeNombreJugador();
                jugador.setNombre(nombreJugador);
                nombreValido = true;
                System.out.println("Bienvenido al juego " + nombreJugador);
            } else {
                mensajeNombreJugador();
                System.out.println("\n");
                System.out.println("╔═══════════════════════════════════════════════════════════╗");
                System.out.println("║ El nombre tiene mas de 50 caracteres, vuelva a intentarlo ║");
                System.out.println("╚═══════════════════════════════════════════════════════════╝");
            }
        }
    }

    public void seleccionarPokemon(Jugador jugador, JugadorView jugadorView) {

        Scanner scanner = new Scanner(System.in);
        boolean pokemonValido = false;
        while (!pokemonValido) {
            System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
            jugadorView.mostrarPokemones();
            System.out.println("Ingrese el nombre del pokemon: ");
            String nombrepokemon = scanner.next();
            pokemonValido = jugador.elegirPokemon(nombrepokemon);
        }
        jugadorView.setPokemonActualView(jugador.getPokemonActual());
    }

    public void opcionesJugadores(Jugador jugador, GeneralView generalView) {

        Scanner scanner = new Scanner(System.in);
        String decision;

        if(!jugador.verficarEstadoPokemonActual()){
            this.seleccionarPokemon(jugador, generalView.getJugadorView());
        }

        while (jugador.isAtacante()) {
            generalView.mostrarMensajeMenu();
            System.out.println("TURNO: " + jugador.getNombre());
            System.out.println("POKEMON: " + jugador.getNombrePokemonActual());
            System.out.println("SELECCIONE UNA OPCION: ");
            decision = scanner.next();
            if(opciones.containsKey(decision)){
                opciones.get(decision).aplicarOpcion(jugador, generalView);
            }else{
                generalView.mostrarMensajeOpcionInvalida();
            }
        }
    }
}
