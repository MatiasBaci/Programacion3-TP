package org.fiuba.algoritmos3;

import java.util.Scanner;

public class Controlador {

    //Metodos:

    public void mensajeBienvenida(){
        System.out.println("====================");
        System.out.println("BIENVENIDO A POKEMON");
        System.out.println("====================");
    }

    public void mensajeHabilidad(){
        System.out.println("==============");
        System.out.println("USAR HABILIDAD");
        System.out.println("==============");
    }

    public void mensajeItem(){
        System.out.println("=========");
        System.out.println("USAR ITEM");
        System.out.println("=========");
    }

    public void mensajeCambiar(){
        System.out.println("===============");
        System.out.println("CAMBIAR POKEMON");
        System.out.println("===============");
    }

    public void mensajeRendirse(){
        System.out.println("========");
        System.out.println("RENDIRSE");
        System.out.println("==========");
    }

    public void menuSeleccion(Jugador jugador1, Jugador jugador2){
        mensajeBienvenida();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String nombreJugador1 = scanner.next();
        jugador1.setNombre(nombreJugador1);
        System.out.println("El jugador 1 es: " + jugador1.getNombre());
        System.out.println("Ingrese el nombre del jugador 2: ");
        String nombreJugador2 = scanner.next();
        jugador2.setNombre(nombreJugador2);
        System.out.println("El jugador 2 es: " + jugador2.getNombre());

    }
}
