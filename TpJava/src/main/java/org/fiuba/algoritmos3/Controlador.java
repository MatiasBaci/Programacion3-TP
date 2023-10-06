package org.fiuba.algoritmos3;

import java.util.*;
import static org.fiuba.algoritmos3.Constantes.*;

public class Controlador {

    Map<String, Opciones> opciones;

    //Metodos:

    public void inicializarOpciones(){

        opciones = new HashMap<>();
        opciones.put(OPCION_UNO, new Rendirse());
        opciones.put(OPCION_DOS, new VerCampoDeBatalla());
        opciones.put(OPCION_TRES, new IntercambiarPokemon());
        opciones.put(OPCION_CUATRO, new AplicarItem());
        opciones.put(OPCION_CINCO, new Atacar());

    }
    public void mensajeBienvenida() {
        System.out.println("╔═══════════════════════╗");
        System.out.println("║ BIENVENIDO A POKEMON  ║");
        System.out.println("╚═══════════════════════╝");
    }

    private void mensajeMenu() {

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║           MENU            ║");
        System.out.println("║═══════════════════════════║");
        System.out.println("║                           ║");
        System.out.println("║ 1 => Rendirse             ║");
        System.out.println("║                           ║");
        System.out.println("║ 2 => Ver campo de batalla ║ ");
        System.out.println("║                           ║");
        System.out.println("║ 3 => Intercambiar Pokemon ║");
        System.out.println("║                           ║");
        System.out.println("║ 4 => Aplicar item         ║");
        System.out.println("║                           ║");
        System.out.println("║ 5 => Atacar               ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("\n");


    }

    private void mensajeNombreJugador() {
        System.out.println("\n");
        System.out.println("╔════════════════════╗");
        System.out.println("║ Eleccion de nombre ║ ");
        System.out.println("╚════════════════════╝");
        System.out.println("\n");
    }


    private void mensajeOpcionInvalida() {
        System.out.println("\n");
        System.out.println("╔═════════════════╗");
        System.out.println("║ Opcion Invalida ║");
        System.out.println("╚═════════════════╝");
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


    public void felicitar(Jugador jugador) {
        System.out.println("¡¡Felicidades a " + jugador.getNombre() + "!! Ganaste el juego");
    }


    public void seleccionarPokemon(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        boolean pokemonValido = false;
        while (!pokemonValido) {
            System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
            jugador.mostrarPokemones();
            System.out.println("Ingrese el nombre del pokemon: ");
            String nombrepokemon = scanner.next();
            pokemonValido = jugador.elegirPokemon(nombrepokemon);
        }
    }

    public void opcionesJugadores(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        String decision;

        if(!jugador.verficarEstadoPokemonActual()){
            this.seleccionarPokemon(jugador);
        }

        while (jugador.isAtacante()) {
            this.mensajeMenu();
            System.out.println("TURNO: " + jugador.getNombre());
            System.out.println("POKEMON: " + jugador.getNombrePokemonActual());
            System.out.println("SELECCIONE UNA OPCION: ");
            decision = scanner.next();
            if(opciones.containsKey(decision)){
                opciones.get(decision).aplicarOpcion(jugador, jugador.getAdversario());
            }else{
                this.mensajeOpcionInvalida();
            }
        }
    }
}
