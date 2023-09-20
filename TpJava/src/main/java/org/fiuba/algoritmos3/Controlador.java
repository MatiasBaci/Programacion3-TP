package org.fiuba.algoritmos3;

import java.util.Objects;
import java.util.Scanner;

public class Controlador {

    //Metodos:


    private void mensajeBienvenida() {
        System.out.println("====================");
        System.out.println("BIENVENIDO A POKEMON");
        System.out.println("====================");
    }

    private void mensajeMenu() {
        System.out.println("====================");
        System.out.println("       MENU");
        System.out.println("====================");
        System.out.println("");

        System.out.println("====================");
        System.out.println("  1 => Rendirse");
        System.out.println("====================");
        System.out.println("");

        System.out.println("==========================");
        System.out.println("2 => Ver campo de batalla");
        System.out.println("==========================");
        System.out.println("");

        System.out.println("============================");
        System.out.println(" 3 => Intercambiar Pokemon");
        System.out.println("============================");
        System.out.println("");

        System.out.println("=========================");
        System.out.println("4 => Aplicar item");
        System.out.println("=========================");
        System.out.println("");

        System.out.println("=========================");
        System.out.println("      5 => Atacar");
        System.out.println("=========================");
        System.out.println("");

        System.out.println("=========================");

        System.out.println("");


    }


    private void mensajeNombreJugador() {
        System.out.println("");
        System.out.println("==================");
        System.out.println("Eleccion de nombre");
        System.out.println("==================");
        System.out.println("");
    }

    private void mensajePokemonInicial() {
        System.out.println("============================");
        System.out.println("Seleccion de Pokemon Inicial");
        System.out.println("============================");
        System.out.println("");

        System.out.println("==========================================================");
        System.out.println("Tenga en cuenta que empieza el pokemon con mayor velocidad");
        System.out.println("==========================================================");
    }


    private void validarNombresJugador(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        Boolean nombreValido = false;
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
                System.out.println("El nombre tiene mas de 50 caracteres, vuevla a intentar");
            }
        }

    }

    private void seleccionarPokemonInicial(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        Boolean pokemonValido = false;
        while (!pokemonValido) {
            mensajePokemonInicial();
            System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
            jugador.getMisPokemones().forEach((k, v) -> System.out.println(v.getNombre() + "-" + v.getNivel() + "-" + v.getEstadisticas().getVelocidad()));
            System.out.println("Ingrese el nombre del pokemon: ");
            String nombrepokemon = scanner.next();
            pokemonValido = jugador.elegirPokemon(nombrepokemon);
        }

    }

    private void compararIniciales(Jugador jugador1, Jugador jugador2) {
        if (jugador1.getPokemonActual().getEstadisticas().getVelocidad() >= jugador2.getPokemonActual().getEstadisticas().getVelocidad()) {
            jugador1.setAtacante(true);
            System.out.println("Comienza atacando " + jugador1.getNombre());
        } else {
            jugador2.setAtacante((true));
            System.out.println("Comienza atacando " + jugador2.getNombre());
        }
    }

    public void opcionRendirse(Jugador jugadorActual){
        System.out.println("Usted se rindio");
        jugadorActual.setAtacante(false);

    }

    public void menuSeleccion(Jugador jugador1, Jugador jugador2) {

        mensajeBienvenida();
        validarNombresJugador(jugador1);
        validarNombresJugador(jugador2);
        seleccionarPokemonInicial(jugador1);
        seleccionarPokemonInicial(jugador2);
        compararIniciales(jugador1, jugador2);


    }

    public void opcionesJugadores(Jugador jugadorActual) {

        Scanner scanner = new Scanner(System.in);
        String numeroOpcion;

        while (jugadorActual.isAtacante()) {
            mensajeMenu();
            numeroOpcion = scanner.next();
            if(Objects.equals(numeroOpcion, "1")){
                opcionRendirse(jugadorActual);
                jugadorActual.setGanoJuego(true);
            }
            if(Objects.equals(numeroOpcion, "2")){

            }
            if(Objects.equals(numeroOpcion, "3")){

            }
            if(Objects.equals(numeroOpcion, "4")){

            }
            if(Objects.equals(numeroOpcion, "5")){

            }
            else{

            }

        }
    }

    public void iteracionesJugadores(Jugador jugador1, Jugador jugador2) {

        while (!jugador1.isGanoJuego() && !jugador2.isGanoJuego()) {

            if (jugador1.isAtacante()) {
                System.out.println("Es el turno de " + jugador1.getNombre());
                opcionesJugadores(jugador1);
                jugador2.setAtacante(true);
            } else if (jugador2.isAtacante()) {
                System.out.println("Es el turno de " + jugador2.getNombre());
                opcionesJugadores(jugador2);
                jugador1.setAtacante(true);
            }
        }
    }
}