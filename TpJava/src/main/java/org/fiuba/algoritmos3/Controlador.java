package org.fiuba.algoritmos3;

import javax.naming.ldap.UnsolicitedNotification;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Controlador {


    //[k,v] -> String input -> metodoQueSeUsa
    //Metodos:



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
                    System.out.println("╔═══════════════════════════════════════════════════════════╗");
                    System.out.println("║ El nombre tiene mas de 50 caracteres, vuelva a intentarlo ║");
                    System.out.println("╚═══════════════════════════════════════════════════════════╝");
                }
            }
    }

    public void seleccionarPokemon(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
            boolean pokemonValido = false;
            while (!pokemonValido) {
                mensajePokemonInicial();
                System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
                jugador.mostrarPokemones();
                System.out.println("Ingrese el nombre del pokemon: ");
                String nombrepokemon = scanner.next();
                pokemonValido = jugador.elegirPokemon(nombrepokemon);
            }
    }





    public void opcionRendirse(Jugador jugador, Jugador jugadorAdversario){
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");

        jugador.setAtacante(false);
        System.out.println("¡¡Felicidades a " + jugadorAdversario.getNombre() + "!! Ganaste el jeugo");


        jugadorAdversario.setGanoJuego(true);
        jugador.setAtacante(false);

    }


    public  void opcionVerCampoBatalla(Jugador jugador, Jugador jugadorAdversario){

        Scanner scanner = new Scanner(System.in);
        jugador.mostrarPokemones();
        jugadorAdversario.mostrarPokemones();
        System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");
        String numeroOpcion = scanner.next();
    }


    public void opcionInercambarPokemon(Jugador jugador){

        //Hay que modularizar y que aparezaca el emnsaje de cambio en el oponente.

        mensajeIntercambiarPokemon();
        System.out.println("Sus pokemones actuales son: ");
        Pokemon pokemonAuxliar = jugador.getPokemonActual();
        seleccionarPokemon(jugador);
        System.out.println("Desea Realizar el cambio? Si - No");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();
        if(Objects.equals(decision, "No")){
            jugador.setPokemonActual(pokemonAuxliar);
            System.out.println("No se realizo el cambio. ");

        }
        else{
            System.out.println("Se realizo el cambio. ");
            jugador.setAtacante(false);
        }
    }



    public void opcionesJugadores(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        String numeroOpcion;

        while (jugador.isAtacante()) {
            this.mensajeMenu();
            numeroOpcion = scanner.next();
            if(Objects.equals(numeroOpcion, "1")){
                opcionRendirse(jugador, jugador.getAdversario());
            }
            else if(Objects.equals(numeroOpcion, "2")){
                opcionVerCampoBatalla(jugador, jugador.getAdversario());
            }
            else if(Objects.equals(numeroOpcion, "3")){
                opcionInercambarPokemon(jugador);
            }
            else if(Objects.equals(numeroOpcion, "4")){
                }
            else if(Objects.equals(numeroOpcion, "5")){
            } else{
                this.mensajeOpcionInvalida();
            }
        }
    }

}