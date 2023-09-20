package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador{

    //Atributos:
    private String nombre;

    private Map<String,Pokemon> misPokemones;
    private List<Items> items;

    private Pokemon pokemonActual;

    private Jugador enemigo;
    private boolean atacante; //Si es atacante es su turno.

    // Metodos:

    public Jugador(String nombre, Map<String,Pokemon> misPokemones, List<Items> items) {
        this.nombre = nombre;
        this.misPokemones = misPokemones;
        this.items = items;
        this.atacante = false;
    }
    public List<Items> getItems() {return items;}


    public Pokemon getPokemonActual() {return pokemonActual;}

    private Pokemon seleccionarPokemon(String unPokemon){
        return this.misPokemones.get(unPokemon);
    }
    public boolean elegirPokemon(String unPokemon){
        if(this.seleccionarPokemon(unPokemon)== null){
            System.out.println("ERROR: No se encontro el pokemon en tu mochila :C ");
            return false;
        }
        this.pokemonActual = this.seleccionarPokemon(unPokemon);
        System.out.println("Seleccionaste el pokemon -> "+ this.pokemonActual.getNombre());
        return true;
    }

    public void añadirAdversario(Jugador unEnemigo){
        // NECESARIAMENTE SE DEBE PENSAR SI ESTO ESTA EN JUGADOR O EN EL JUEGO :3 pero de alguna manera se tiene que llenar.
        this.enemigo = unEnemigo;
    }

    public void atacarAdversario(){ // puede recibir la opcion de la habilidada elegida y usarala para buscarla en pokemon
        if(this.pokemonActual == null){
            System.out.println("ERROR: Primero elige tu pokemon >:V ");
        }

        Habilidad unaHabilidad = this.pokemonActual.seleccionarHabilidad("ChorroDeAgua"); //Aqui no es flexible por ende deberia estar como parametro en el metodo
        this.pokemonActual.atacar(this.enemigo.getPokemonActual(),unaHabilidad); // es flexible, puede ser otra habilidad que no sea ataque
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Map<String, Pokemon> getMisPokemones() {
        return misPokemones;
    }

    public void setAtacante(boolean atacante) {
        this.atacante = atacante;
    }

    public boolean isAtacante() {
        return atacante;
    }
}


