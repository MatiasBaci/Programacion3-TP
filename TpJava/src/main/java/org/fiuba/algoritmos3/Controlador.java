package org.fiuba.algoritmos3;

import javax.naming.ldap.UnsolicitedNotification;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Controlador {
     //[k,v] -> String input -> metodoQueSeUsa
    //Metodos:

    private void mensajeBienvenida() {
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
        System.out.println("║  5 => Atacar              ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println(" ");
        System.out.println("Seleccione una de las opciones: ");


    }

    private void mensajeCampoBatalla(){
        System.out.println(" ");
        System.out.println("╔══════════════════╗");
        System.out.println("║ Campo de Batalla ║");
        System.out.println("╚══════════════════╝");
        System.out.println(" ");
    }


    private void mensajeIntercambiarPokemon() {
        System.out.println(" ");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Intercambiar Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println(" ");
    }


    private void mensajeNombreJugador() {
        System.out.println(" ");
        System.out.println("╔════════════════════╗");
        System.out.println("║ Eleccion de nombre ║ ");
        System.out.println("╚════════════════════╝");
        System.out.println(" ");
    }

    private void mensajePokemonInicial() {
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Seleccion de Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println(" ");

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ Tenga en cuenta que empieza el pokemon con mayor velocidad ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private void mensajeOpcionInvalida(){
        System.out.println(" ");
        System.out.println("╔═════════════════╗");
        System.out.println("║ Opcion Invalida ║");
        System.out.println("╚═════════════════╝");
        System.out.println(" ");

    }


    private void validarNombresJugador(Jugador jugador) {
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
                    System.out.println("╔═══════════════════════════════════════════════════════════╗");
                    System.out.println("║ El nombre tiene mas de 50 caracteres, vuelva a intentarlo ║");
                    System.out.println("╚═══════════════════════════════════════════════════════════╝");
                }
            }
    }

    private void seleccionarPokemon(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
            boolean pokemonValido = false;
            while (!pokemonValido) {
                mensajePokemonInicial();
                System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
                System.out.println(" ");
                jugador.getMisPokemones().forEach((k, v) -> System.out.println("*" + v.getNombre() + " Lv: " + v.getNivel() + " Velocidad: " + v.getEstadisticas().getVelocidad() + " Hp: " + v.getEstadisticas().getVidaMaxima()));
                System.out.println(" ");
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

    public void opcionRendirse(Jugador jugadorActual, Jugador jugadorAdversario){
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");
        jugadorActual.setAtacante(false);
        jugadorAdversario.setGanoJuego(true);
        System.out.println("¡¡Felicidades a " + jugadorAdversario.getNombre() + "!! Ganaste el jeugo");
    }

    private void mostratDatosPokemones(String nombre,Pokemon unPokemon,Estadisticas estadisticasPropias){
        System.out.println(" ");
        System.out.println("=>" + nombre);
        System.out.println("Nombre: " + unPokemon.getNombre());
        System.out.println("*LV: " + unPokemon.getNivel());
        System.out.println("*HP: " + estadisticasPropias.getVidaMaxima());
        System.out.println("Estado: " + unPokemon.getEstadoActual());
        System.out.println(" ");
    }
    public  void opcionVerCampoBatalla(Jugador unJugador,Pokemon unPokemon){
        mostratDatosPokemones(unJugador.getNombre(),unPokemon,unPokemon.getEstadisticas());
    }


    public void opcionInercambarPokemon(Jugador jugadorActual){

        //Hay que modularizar y que aparezaca el emnsaje de cambio en el oponente.

        mensajeIntercambiarPokemon();
        System.out.println("Sus pokemones actuales son: ");
        Pokemon pokemonAuxliar = jugadorActual.getPokemonActual();
        seleccionarPokemon(jugadorActual);
        System.out.println("Desea Realizar el cambio? Si - No");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();
        if(Objects.equals(decision, "No")){
            jugadorActual.setPokemonActual(pokemonAuxliar);
            System.out.println("No se realizo el cambio. ");
            jugadorActual.setAtacante(false);
        }
        else{
            System.out.println("Se realizo el cambio. ");
        }
    }

    public void menuSeleccion(Jugador jugador1, Jugador jugador2) {

        mensajeBienvenida();
        validarNombresJugador(jugador1);
        validarNombresJugador(jugador2);
        seleccionarPokemon(jugador1);
        seleccionarPokemon(jugador2);
        compararIniciales(jugador1, jugador2);

    }

    public void opcionesJugadores(Jugador jugadorActual,Jugador jugadorAdversario) {

        Scanner scanner = new Scanner(System.in);
        String numeroOpcion;

            while (jugadorActual.isAtacante()) {
                this.mensajeMenu();
                numeroOpcion = scanner.next();
                if(Objects.equals(numeroOpcion, "1")){
                    opcionRendirse(jugadorActual, jugadorAdversario);
                }
                else if(Objects.equals(numeroOpcion, "2")){
                    this.mensajeCampoBatalla();
                    opcionVerCampoBatalla(jugadorActual,jugadorActual.getPokemonActual());
                    opcionVerCampoBatalla(jugadorAdversario,jugadorAdversario.getPokemonActual());
                    System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");

                }
                else if(Objects.equals(numeroOpcion, "3")){
                    opcionInercambarPokemon(jugadorActual);

                }
                else if(Objects.equals(numeroOpcion, "4")){

                }
                else if(Objects.equals(numeroOpcion, "5")){
                }
                else{
                    this.mensajeOpcionInvalida();
                }
                numeroOpcion = scanner.next();
            }
    }

    public void iteracionesJugadores(Jugador jugador1, Jugador jugador2) {

        while (!jugador1.isGanoJuego() && !jugador2.isGanoJuego()) {

            if (jugador1.isAtacante()) {
                System.out.println("Es el turno de " + jugador1.getNombre());
                this.opcionesJugadores(jugador1,jugador2);
                jugador2.setAtacante(true);
            } else if (jugador2.isAtacante()) {
                System.out.println("Es el turno de " + jugador2.getNombre());
                this.opcionesJugadores(jugador2,jugador1);
                jugador1.setAtacante(true);
            }
        }
    }
}