package org.fiuba.algoritmos3;

import java.util.Scanner;

public class Controlador {

    //Metodos:


    private void mensajeBienvenida(){
        System.out.println("====================");
        System.out.println("BIENVENIDO A POKEMON");
        System.out.println("====================");
    }

    private void mensajeHabilidad(){
        System.out.println("==============");
        System.out.println("USAR HABILIDAD");
        System.out.println("==============");
    }

    private void mensajeItem(){
        System.out.println("=========");
        System.out.println("USAR ITEM");
        System.out.println("=========");
    }

    private void mensajeCambiar(){
        System.out.println("===============");
        System.out.println("CAMBIAR POKEMON");
        System.out.println("===============");
    }

    private void mensajeRendirse(){
        System.out.println("========");
        System.out.println("RENDIRSE");
        System.out.println("==========");
    }

    private void mensajeNombreJugador(){
        System.out.println("");
        System.out.println("==================");
        System.out.println("Eleccion de nombre");
        System.out.println("==================");
        System.out.println("");
    }

    private void mensajePokemonInicial(){
        System.out.println("============================");
        System.out.println("Seleccion de Pokemon Inicial");
        System.out.println("============================");
        System.out.println("");

        System.out.println("==========================================================");
        System.out.println("Tenga en cuenta que empieza el pokemon con mayor velocidad");
        System.out.println("==========================================================");
    }



    private void validarNombresJugador(Jugador jugador){
        Scanner scanner = new Scanner(System.in);
        Boolean nombreValido = false;
        while(!nombreValido) {
            mensajeNombreJugador();
            System.out.println("Ingrese el nombre del jugador: ");
            String nombreJugador = scanner.next();
            if (nombreJugador.length() < 50){
                mensajeNombreJugador();
                jugador.setNombre(nombreJugador);
                nombreValido = true;
                System.out.println("Bienvenido al juego " + nombreJugador);
            }
            else {
                mensajeNombreJugador();
                System.out.println("El nombre tiene mas de 50 caracteres, vuevla a intentar");
            }
        }

    }

    private void seleccionarPokemonInicial(Jugador jugador){

        Scanner scanner = new Scanner(System.in);
        Boolean pokemonValido = false;
        while(!pokemonValido){
            mensajePokemonInicial();
            System.out.println("Los pokemones disponibles de " + jugador.getNombre() + " son: ");
            jugador.getMisPokemones().forEach((k,v) -> System.out.println(v.getNombre() + "-" + v.getNivel() + "-" + v.getEstadisticas().getVelocidad()));
            System.out.println("Ingrese el nombre del pokemon: ");
            String nombrepokemon = scanner.next();
            pokemonValido = jugador.elegirPokemon(nombrepokemon);
        }

    }

    private void compararIniciales(Jugador jugador1, Jugador jugador2){
        if(jugador1.getPokemonActual().getEstadisticas().getVelocidad() >= jugador2.getPokemonActual().getEstadisticas().getVelocidad()){
            jugador1.setAtacante(true);
            System.out.println("Comienza atacando " + jugador1.getNombre());
        }
        else{
            jugador2.setAtacante((true));
            System.out.println("Comienza atacando " + jugador2.getNombre());
        }
    }

    public void menuSeleccion(Jugador jugador1, Jugador jugador2){

        mensajeBienvenida();
        validarNombresJugador(jugador1);
        validarNombresJugador(jugador2);
        seleccionarPokemonInicial(jugador1);
        seleccionarPokemonInicial(jugador2);
        compararIniciales(jugador1, jugador2);

    }
}
