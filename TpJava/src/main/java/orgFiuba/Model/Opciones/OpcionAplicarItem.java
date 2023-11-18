package orgFiuba.Model.Opciones;

import orgFiuba.Model.Items.Item;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.Model.Jugador;
import orgFiuba.Model.ServicioDeUserInput;
import orgFiuba.View.GeneralView;

import static orgFiuba.Constantes.*;

public class OpcionAplicarItem implements Opcion{

    private void decidirAplicarItem(Jugador jugador, String nombrePokemon, Item itemAplicable, GeneralView generalView){


        System.out.println(ANSI_VERDEOSCURO + "Desea aplicar el item? Si - No:" + ANSI_RESET);

        String decision = ServicioDeUserInput.input();

        if(!decision.equalsIgnoreCase("si")){
            System.out.println(ANSI_ROJO + "No se aplico el Item seleccionado." + ANSI_RESET);
            return;
        }
        if(!generalView.getJugadorView().mostrarCasosDeApliacionItem(itemAplicable)){
            return;
        }
        Pokemon pokemnAux = jugador.getMisPokemones().get(nombrePokemon);
        generalView.mostrarCasoModicicacion(itemAplicable.getUnaModificacion(), pokemnAux);
        if(jugador.usarItem(nombrePokemon, itemAplicable)) {
            generalView.mostrarMensajeAplicoItem(jugador, itemAplicable.getNombre());


            decision = ServicioDeUserInput.input();
        }



    }
    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeOpcionAplicarItem();
        String nombreItem = ServicioDeUserInput.input();

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
        String nombrePokemon = ServicioDeUserInput.input();
        if(!jugador.validadorClavePokemones(nombrePokemon)){
            System.out.println(ANSI_ROJO + "ERROR: NO SE ENCONTRO EL POKEMON" + ANSI_RESET);
            return;
        }
        this.decidirAplicarItem(jugador,nombrePokemon,itemAplicable, generalView);

    }
}

