package Opciones;

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
        jugador.usarItem(nombrePokemon, itemAplicable);
    }

}
