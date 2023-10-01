package org.fiuba.algoritmos3;
// import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Jugador {

    //Atributos:
    private String nombre;

    private Map<String, Pokemon> misPokemones;
    private Map<String, Item> items;

    private Pokemon pokemonActual;

    private Jugador adversario;
    private boolean atacante; //Si es atacante es su turno.
    private boolean ganoJuego;  //True si gano el juego

    // Metodos:

    public Jugador(String nombre, Map<String, Pokemon> misPokemones, Map<String, Item> items) {
        this.nombre = nombre;
        this.misPokemones = misPokemones;
        this.items = items;
        this.atacante = false;
    }

    public Map<String, Item> getItems() {
        return items;
    }


    public Pokemon getPokemonActual() {
        return pokemonActual;
    }


    private Pokemon seleccionarPokemon(String unPokemon) {
        return this.misPokemones.get(unPokemon);
    }


    public boolean elegirPokemon(String unPokemon) {
        if (this.seleccionarPokemon(unPokemon) == null) {
            System.out.println("ERROR: No se encontro el pokemon en tu mochila :C ");
            return false;
        } else if (this.seleccionarPokemon(unPokemon).getEstadisticas().getVidaMaxima() == 0) { //Hay get().get()
            System.out.println("ERROR: El pokemon no tiene vida. :C ");
            return false;
            // } //else if(this.seleccionarPokemon(unPokemon).getNombre() == pokemonActual.getNombre()){
            //System.out.println("Estas eligindo a tu Pokemon actual. :C ");
            // return false;
        }
        this.pokemonActual = this.seleccionarPokemon(unPokemon);
        System.out.println("Seleccionaste el pokemon -> " + this.pokemonActual.getNombre());
        return true;
    }


    public void elegirItem() {

    }


    public void añadirAdversario(Jugador unEnemigo) {
        this.adversario = unEnemigo;
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


    public void setGanoJuego(boolean ganoJuego) {
        this.ganoJuego = ganoJuego;
    }


    public boolean isGanoJuego() {
        return ganoJuego;
    }


    public Jugador getAdversario() {
        return adversario;
    }


    public void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }


    public void mostrarPokemones() {
        System.out.println("-----------------------------------------------------------------");
        misPokemones.forEach((k, v) -> v.mostrarPokemon());
        System.out.println("-----------------------------------------------------------------");
    }


    public void ganar() {
        ganoJuego = true;
    }


    public void mostratHabilidadesPokemonActual() {

        System.out.println("Las habilidades de " + pokemonActual.getNombre() + " actuales son: ");
        pokemonActual.mostrarHabilidades();
    }


    public void aplicarEfectoPasivo() {
        pokemonActual.aplicarEfectoPasivoPokemon();
    }


/*     public String validarHabilidad() {
        boolean validarHabilidad = false;
        while(!validarHabilidad) {
            validarHabilidad = this.pokemonActual.validarHabilidar(nombreHabilidad);
        }
    } */


    public void atacarJugador(Jugador jugadorAdversario, String nombreHabilidad){

        pokemonActual.atacar(jugadorAdversario.getPokemonActual(), nombreHabilidad);
        setAtacante(false);

    }


    public boolean intercambiarPokemon(String decision, Pokemon pokemon){

        if (Objects.equals(decision, "No")) {
            this.setPokemonActual(pokemon);
            System.out.println("No se realizo el intercambio. ");
            return false;

        } else {
            System.out.println("Se realizo el intercambio. ");
            this.setAtacante(false);
            return true;
        }
    }

    public void mostrarItems() {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Items de " + this.nombre);
        items.forEach((k, v) -> v.mostrarItem());
        System.out.println("-----------------------------------------------------------------");
    }

    public Item elegirItem(String nombreItem){

        return this.items.get(nombreItem);

    }

    public boolean validadorClaveItems(String nombreItem){
        return this.items.containsKey(nombreItem);
    }

    public boolean validadorClavePokemones(String nombrePokemon){
        return this.misPokemones.containsKey(nombrePokemon);
    }

    public void usarItem(String nombrePokemon, Item itemAplicable){
        itemAplicable.realizarCasosDeApliacion(misPokemones.get(nombrePokemon));
    }

}


