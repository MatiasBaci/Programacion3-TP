package org.fiuba.algoritmos3;
// import java.util.ArrayList;
import Item.Item;

import java.util.Map;
import java.util.Objects;

public class Jugador {

    //Atributos:
    private String nombre;

    private Map<String, Pokemon> misPokemones;
    private Map<String, Item> items;

    private Pokemon pokemonActual;

    private Jugador adversario;
    private boolean atacante;

    // Metodos:

    public Jugador(String nombre, Map<String, Pokemon> misPokemones, Map<String, Item> items) {
        this.nombre = nombre;
        this.misPokemones = misPokemones;
        this.items = items;
        this.atacante = false;
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getAdversario() { return adversario; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtacante(boolean atacante) {
        this.atacante = atacante;
    }

    public void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }

    public boolean isAtacante() {
        return atacante;
    }

    public boolean perdio() {
        return !this.misPokemones.values().stream().anyMatch(Pokemon::estaConciente);
    }

    private Pokemon seleccionarPokemon(String unPokemon) {
        return this.misPokemones.get(unPokemon);
    }

    public void añadirAdversario(Jugador unEnemigo) {
        this.adversario = unEnemigo;
    }

    public void aplicarEfectoPasivo() {
        pokemonActual.aplicarEfectoPasivoPokemon();
    }

    public boolean elegirPokemon(String unPokemon) {
        if (this.seleccionarPokemon(unPokemon) == null) {
            System.out.println("ERROR: No se encontro el pokemon en tu mochila :C ");
            return false;
        }
        else if (!this.seleccionarPokemon(unPokemon).estaConciente()) {
            System.out.println("ERROR: El pokemon no tiene vida. :C ");
            return false;
        }
        else if(this.pokemonActual != null){
            if(Objects.equals(unPokemon, pokemonActual.getNombre())) {
                System.out.println("Estas eligindo a tu Pokemon actual. :C ");
                return false;
            }
        }
        this.pokemonActual = this.seleccionarPokemon(unPokemon);
        System.out.println("Seleccionaste el pokemon -> " + this.pokemonActual.getNombre());
        return true;
    }



    public void atacarJugador(Jugador jugadorAdversario, String nombreHabilidad){

        if(!this.validarHabilidadPokemon(nombreHabilidad)) {
            System.out.println("La habilidad no existe. ");
        }
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

    public Item elegirItem(String nombreItem){
        return this.items.get(nombreItem);
    }

    public void usarItem(String nombrePokemon, Item itemAplicable){
        if (itemAplicable.realizarCasosDeApliacion(misPokemones.get(nombrePokemon))){
            this.setAtacante(false);
        }

    }

    public void mostrarPokemones() {
        System.out.println("-----------------------------------------------------------------");
        misPokemones.forEach((k, v) -> v.mostrarPokemon());
        System.out.println("-----------------------------------------------------------------");
    }

    public void mostratHabilidadesPokemonActual() {
        System.out.println("Las habilidades de " + pokemonActual.getNombre() + " actuales son: ");
        pokemonActual.mostrarHabilidades();
    }

    public void mostrarItems() {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Items de " + this.nombre);
        items.forEach((k, v) -> v.mostrarItem());
        System.out.println("-----------------------------------------------------------------");
    }

    public boolean validarHabilidadPokemon(String nombreHabilidad){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoHabilidad(nombreHabilidad,this.pokemonActual.getMisHabilidades());
    }

    public boolean validadorClaveItems(String nombreItem){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoItem(nombreItem,this.items);
    }


    public boolean validadorClavePokemones(String nombrePokemon){
        Validacion validacion = new Validacion();
        return validacion.estaContenidoPokemon(nombrePokemon,this.misPokemones);
    }
    public boolean verficarEstadoPokemonActual(){
        return this.pokemonActual.estaConciente();
    }

}


