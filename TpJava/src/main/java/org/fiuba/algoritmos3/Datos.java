package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Esta clase se encarga de cargar los datos de ambos jugadores nada mas.
public class Datos {

    //Atributos:
    private Map<String, Pokemon> mochilaJugador1;
    private Map<String, Pokemon> mochilaJugador2;
    private List<Items> itemsJugador1;
    private List<Items> itemsJugador2;
    private String nombreJugador1;
    private String nombreJugador2;

    //Metodos:

    public Datos(){

        mochilaJugador1 = new HashMap<>();
        mochilaJugador2 = new HashMap<>();
        itemsJugador1 = new ArrayList<>();
        itemsJugador2 = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon("Squirtle",5,"Agua","Es un pokemon de Agua",100,15,20,20);
        Pokemon pokemon2 = new Pokemon("Charmander",5,"Fuego","Es un pokemon de Fuego",100,20,25,25);
        Pokemon pokemon3 = new Pokemon("Pikachu",5,"Agua","Es un pokemon de Agua",100,15,20,20);
        Pokemon pokemon4 = new Pokemon("Charizard",5,"Fuego","Es un pokemon de Fuego",100,20,25,25);
        Pokemon pokemon5 = new Pokemon("Vaporeon",5,"Fuego","Es un pokemon de Fuego",100,20,25,25);
        Pokemon pokemon6 = new Pokemon("Charmander_1",10,"Fuego","Es un pokemon de Fuego",100,20,25,25);

        pokemon1.añadirHabilidad("ChorroDeAgua","Agua");
        pokemon2.añadirHabilidad("Lanzallamas","Agua");

        mochilaJugador1.put(pokemon1.getNombre(), pokemon1);
        mochilaJugador1.put(pokemon2.getNombre(), pokemon2);
        mochilaJugador1.put(pokemon3.getNombre(), pokemon3);
        mochilaJugador1.put(pokemon4.getNombre(), pokemon4);
        mochilaJugador1.put(pokemon5.getNombre(), pokemon5);
        mochilaJugador1.put(pokemon6.getNombre(), pokemon6);
        mochilaJugador2.put(pokemon1.getNombre(), pokemon1);
        mochilaJugador2.put(pokemon2.getNombre(), pokemon2);
        mochilaJugador2.put(pokemon3.getNombre(), pokemon3);
        mochilaJugador2.put(pokemon4.getNombre(), pokemon4);
        mochilaJugador2.put(pokemon5.getNombre(), pokemon5);
        mochilaJugador2.put(pokemon6.getNombre(), pokemon6);
    }


    public List<Items> getItemsJugador1() {
        return itemsJugador1;
    }

    public List<Items> getItemsJugador2() {
        return itemsJugador2;
    }

    public Map<String, Pokemon> getMochilaJugador1() {
        return mochilaJugador1;
    }

    public Map<String, Pokemon> getMochilaJugador2() {
        return mochilaJugador2;
    }
}
