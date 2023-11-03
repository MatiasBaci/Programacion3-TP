package Opciones;

import Item.Item;
import Pokemones.Pokemon;
import org.fiuba.algoritmos3.Jugador;
import view.GeneralView;

import java.util.Scanner;

import static org.fiuba.algoritmos3.Constantes.*;

public class OpcionAplicarItem implements Opciones{

    private void decidirAplicarItem(Jugador jugador, String nombrePokemon, Item itemAplicable, GeneralView generalView){

        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_VERDEOSCURO + "Desea aplicar el item? Si - No:" + ANSI_RESET);
        String decision = scanner.next();

        if(!decision.equalsIgnoreCase("si")){
            System.out.println(ANSI_ROJO + "No se aplico el Item seleccionado." + ANSI_RESET);
            return;
        }
        generalView.getJugadorView().mostrarCasosDeApliacionItem(itemAplicable);
        if(jugador.usarItem(nombrePokemon, itemAplicable)) {
            generalView.mostrarMensajeAplicoItem(jugador, itemAplicable.getNombre());

            decision = scanner.next();
        }


        Pokemon pokemnAux = jugador.getMisPokemones().get(nombrePokemon);
        generalView.mostrarCasoModicicacion(itemAplicable.getUnaModificacion(), pokemnAux);
    }
    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeOpcionAplicarItem();
        Scanner scanner = new Scanner(System.in);
        String nombreItem = scanner.nextLine();

        if(!jugador.validadorClaveItems(nombreItem)){
            System.out.println(ANSI_ROJO + "ERROR: NO SE ENCONTRO EL ITEM." + ANSI_RESET);
            return;
        }

        Item itemAplicable = jugador.elegirItem(nombreItem);

        if(!itemAplicable.esUnItemDeSoloCampoDeBatalla()){
            this.decidirAplicarItem(jugador, jugador.getNombrePokemonActual(), itemAplicable, generalView);
            return;
        }
        generalView.getJugadorView().mostrarPokemones();
        System.out.println(ANSI_VERDEOSCURO + "Seleccione el Pokemon a aplicar el item: " + ANSI_RESET);
        String nombrePokemon = scanner.next();
        if(!jugador.validadorClavePokemones(nombrePokemon)){
            System.out.println(ANSI_ROJO + "ERROR: NO SE ENCONTRO EL POKEMON" + ANSI_RESET);
            return;
        }
        this.decidirAplicarItem(jugador,nombrePokemon,itemAplicable, generalView);

    }
}

