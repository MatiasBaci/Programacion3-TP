package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Esta clase se encarga de cargar los datos de ambos jugadores nada mas.
public class Datos {

    //Atributos:
    private Map<String, Pokemon> mochilaDePokemonAsh;
    private Map<String, Pokemon> mochilaDePokemonMario;
    private List<Items> itemsDeAsh;
    private List<Items> itemsDeMario;
    private String nombreJugador1;
    private String nombreJugador2;

    //Metodos:

    public Datos(){

        mochilaDePokemonAsh = new HashMap<>();
        mochilaDePokemonMario = new HashMap<>();
        itemsDeAsh = new ArrayList<>();
        itemsDeMario = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon("Squirtle",5,"Agua","Es un pokemon de Agua",100,15,20,20);
        Pokemon pokemon2 = new Pokemon("Charmander",5,"Fuego","Es un pokemon de Fuego",100,20,25,25);

        pokemon1.añadirHabilidad("ChorroDeAgua","Agua");

        mochilaDePokemonAsh.put(pokemon1.getNombre(), pokemon1);
        mochilaDePokemonMario.put(pokemon2.getNombre(), pokemon2);

    }

    public List<Items> getItemsDeAsh() {
        return itemsDeAsh;
    }

    public List<Items> getItemsDeMario() {
        return itemsDeMario;
    }

    public Map<String, Pokemon> getMochilaDePokemonAsh() {
        return mochilaDePokemonAsh;
    }

    public Map<String, Pokemon> getMochilaDePokemonMario() {
        return mochilaDePokemonMario;
    }
}
