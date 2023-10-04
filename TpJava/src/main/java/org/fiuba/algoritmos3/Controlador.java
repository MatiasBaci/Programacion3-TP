package org.fiuba.algoritmos3;

// import javax.naming.ldap.UnsolicitedNotification;
// import java.util.HashMap;
import Item.Item;

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
        System.out.println("║ 5 => Atacar               ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("\n");


    }

    private void mensajeCampoBatalla() {
        System.out.println("\n");
        System.out.println("╔══════════════════╗");
        System.out.println("║ Campo de Batalla ║");
        System.out.println("╚══════════════════╝");
        System.out.println("\n");
    }


    private void mensajeIntercambiarPokemon() {
        System.out.println("\n");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Intercambiar Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("\n");
    }

    private void mensajeAtacarPokemon() {
        System.out.println("\n");
        System.out.println("╔════════════════╗");
        System.out.println("║ Atacar Pokemon ║");
        System.out.println("╚════════════════╝");
        System.out.println("\n");
    }


    private void mensajeNombreJugador() {
        System.out.println("\n");
        System.out.println("╔════════════════════╗");
        System.out.println("║ Eleccion de nombre ║ ");
        System.out.println("╚════════════════════╝");
        System.out.println("\n");
    }

    private void mensajePokemonInicial() {
        System.out.println("\n");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Seleccion de Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("\n");

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ Tenga en cuenta que empieza el pokemon con mayor velocidad ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private void mensajeOpcionInvalida() {
        System.out.println("\n");
        System.out.println("╔═════════════════╗");
        System.out.println("║ Opcion Invalida ║");
        System.out.println("╚═════════════════╝");
        System.out.println("\n");

    }

    private void mensajeOpcionAplicarItem() {
        System.out.println("\n");
        System.out.println("╔══════════════╗");
        System.out.println("║ Aplicar Item ║");
        System.out.println("╚══════════════╝");
        System.out.println("\n");

    }

    private void limpiarTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
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

   // public void ganar(Jugador jugador) {
     //   this.felicitar(jugador);
       // jugador.ganar();
    //}


    private void felicitar(Jugador jugador) {
        System.out.println("¡¡Felicidades a " + jugador.getNombre() + "!! Ganaste el juego");
    }


    public void opcionRendirse(Jugador jugador, Jugador jugadorAdversario) {
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");

        jugador.setAtacante(false);

        //this.ganar(jugadorAdversario);
    }


    public void opcionVerCampoBatalla(Jugador jugador, Jugador jugadorAdversario) {

        this.mensajeCampoBatalla();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Pokemones de " + jugador.getNombre() + ":");
        jugador.mostrarPokemones();
        System.out.println("Pokemones de " + jugadorAdversario.getNombre() + ":");
        jugadorAdversario.mostrarPokemones();
        System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");
        scanner.next();
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
    public void opcionInercambarPokemon(Jugador jugador) {

        this.mensajeIntercambiarPokemon();
        Pokemon pokemonAuxliar = jugador.getPokemonActual();
        this.seleccionarPokemon(jugador);
        System.out.println("Desea Realizar el cambio? Si - No");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();
        jugador.intercambiarPokemon(decision, pokemonAuxliar);
    }



    public void opcionAtacar(Jugador jugador, Jugador jugadorAdversario) {

        this.mensajeAtacarPokemon();
        jugador.mostratHabilidadesPokemonActual();
        System.out.println("Elige una habilidad: ");
        Scanner scanner = new Scanner(System.in);
        String opcion;
        opcion = scanner.next();

        jugador.atacarJugador(jugadorAdversario, opcion);

    }

    public void opcionAplicarItem(Jugador jugador){

        this.mensajeOpcionAplicarItem();
        Scanner scanner = new Scanner(System.in);
        jugador.mostrarItems();
        System.out.println("Seleccione el item a aplicar: ");
        String nombreItem = scanner.nextLine();

        if(!jugador.validadorClaveItems(nombreItem)){
            System.out.println("No se encontro el item.");
            return;
        }

        Item itemAplicable = jugador.elegirItem(nombreItem);
        jugador.mostrarPokemones();
        System.out.println("Seleccione el Pokemon a aplicar el item: ");
        String nombrePokemon = scanner.next();

        if(!jugador.validadorClavePokemones(nombrePokemon)){
            System.out.println("No se encontro el pokemon");
            return;
        }

        System.out.println("Desea aplicar el item? Si - No:");
        String decision = scanner.next();

        if(!decision.equals("Si")){
            System.out.println("No se aplico el Item seleccionado");
            return;
        }
        jugador.usarItem(nombrePokemon, itemAplicable);
    }
    public void opcionesJugadores(Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        String decision;
        boolean IntercambioPokemon = false;

        if(!jugador.verficarEstadoPokemonActual()){
            this.seleccionarPokemon(jugador);
        }

        while (jugador.isAtacante()) {
            this.mensajeMenu();
            System.out.println("TURNO: " + jugador.getNombre());
            System.out.println("POKEMON: " + jugador.getNombrePokemonActual());
            System.out.println("SELECCIONE UNA OPCION: ");
            decision = scanner.next();

            if (Objects.equals(decision, "1")) {
                this.opcionRendirse(jugador, jugador.getAdversario());
            } else if (Objects.equals(decision, "2")) {
                this.opcionVerCampoBatalla(jugador, jugador.getAdversario());
            } else if (Objects.equals(decision, "3")) {
                this.opcionInercambarPokemon(jugador);
            } else if (Objects.equals(decision, "4")) {
                this.opcionAplicarItem(jugador);
            } else if (Objects.equals(decision, "5")) {
                this.opcionAtacar(jugador, jugador.getAdversario());
            } else {
                this.mensajeOpcionInvalida();
            }

        }
    }


}
