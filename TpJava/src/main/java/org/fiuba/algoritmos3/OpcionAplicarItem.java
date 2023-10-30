package org.fiuba.algoritmos3;

import Item.Item;
import view.GeneralView;
import view.JugadorView;

import java.util.Scanner;

public class OpcionAplicarItem implements Opciones{

    private void decidirAplicarItem(Jugador jugador, String nombrePokemon, Item itemAplicable, GeneralView generalView){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea aplicar el item? Si - No:");
        String decision = scanner.next();

        if(!decision.equals("Si")){
            System.out.println("No se aplico el Item seleccionado");
            return;
        }
        if(jugador.usarItem(nombrePokemon, itemAplicable)) {
            generalView.mostrarMensajeAplicoItem(jugador, itemAplicable.getNombre());
            decision = scanner.next();
        }
    }
    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeOpcionAplicarItem();
        Scanner scanner = new Scanner(System.in);
        String nombreItem = scanner.nextLine();

        if(!jugador.validadorClaveItems(nombreItem)){
            System.out.println("No se encontro el item.");
            return;
        }

        Item itemAplicable = jugador.elegirItem(nombreItem);

        if(!itemAplicable.esUnItemDeSoloCampoDeBatalla()){
            this.decidirAplicarItem(jugador, jugador.getNombrePokemonActual(), itemAplicable, generalView);
            return;
        }
        generalView.getJugadorView().mostrarPokemones();
        System.out.println("Seleccione el Pokemon a aplicar el item: ");
        String nombrePokemon = scanner.next();
        if(!jugador.validadorClavePokemones(nombrePokemon)){
            System.out.println("No se encontro el pokemon");
            return;
        }
        this.decidirAplicarItem(jugador,nombrePokemon,itemAplicable, generalView);
        Pokemon pokemnAux = jugador.getMisPokemones().get(nombrePokemon);
        generalView.mostrarCasoModicicacion(itemAplicable.getUnaModificacion(), pokemnAux);
    }
}

