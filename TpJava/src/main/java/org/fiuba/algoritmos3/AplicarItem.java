package org.fiuba.algoritmos3;

import Item.Item;
import org.fiuba.algoritmos3.Jugador;

import java.util.Scanner;

public class AplicarItem implements Opciones{

    private void mensajeOpcionAplicarItem() {
        System.out.println("\n");
        System.out.println("╔══════════════╗");
        System.out.println("║ Aplicar Item ║");
        System.out.println("╚══════════════╝");
        System.out.println("\n");

    }

    private void mensajeAplicoItem(Jugador jugador, String nombreItem) {

        System.out.println("\n");
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ Se acaba de aplicar un item ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("\n");
        System.out.println("El jugador " + jugador.getNombre() + " acaba de usar " + nombreItem + ".");
        System.out.println("Oprima una tecla para seguir jugando.");
    }
    @Override
    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario){

        //this.mensajeOpcionAplicarItem();
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
        if(jugador.usarItem(nombrePokemon, itemAplicable)) {
            mensajeAplicoItem(jugador, itemAplicable.getNombre());
            decision = scanner.next();
        }
    }

}
