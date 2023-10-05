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
            System.out.println("ERROR: NO SE ENCONTRO EL POKEMON EN LA MOCHILA.");
            System.out.println("\n");
            return false;
        }
        else if (!this.seleccionarPokemon(unPokemon).estaConciente()) {
            System.out.println("ERROR: EL POKEMON NO TIENE VIDA ");
            System.out.println("\n");
            return false;
        }
        else if(this.pokemonActual != null){
            if(Objects.equals(unPokemon, pokemonActual.getNombre())) {
                System.out.println("ESTAS ELIGIENDO A TU POKEMON ACTUAL ");
                System.out.println("\n");
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
            return;
        }
        this.pokemonActual.atacar(jugadorAdversario.getPokemonActual(), nombreHabilidad);
        setAtacante(false);
    }

    private void mensajeIntercambioAlAdversario(){

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║ El Adversario Intercambio el Pokemon ║ ");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("\n");

    }

    public void intercambiarPokemon(String decision, Pokemon pokemon){

        if (Objects.equals(decision, "Si")) {
            //System.out.println("Se realizo el intercambio. ");
            mensajeIntercambioAlAdversario();
            this.setAtacante(false);

        } else {
            this.setPokemonActual(pokemon);
            System.out.println("No se realizo el intercambio. ");

        }
    }

    public Item elegirItem(String nombreItem){
        return this.items.get(nombreItem);
    }

    public boolean usarItem(String nombrePokemon, Item itemAplicable){
        if (itemAplicable.realizarCasosDeApliacion(this.misPokemones.get(nombrePokemon))){
            this.setAtacante(false);
            return true;
        }
        return false;

    }

    public void mostrarPokemones() {
        System.out.println("-----------------------------------------------------------------");
        this.misPokemones.forEach((k, v) -> v.mostrarPokemon());
        System.out.println("-----------------------------------------------------------------");
    }

    public void mostratHabilidadesPokemonActual() {
        System.out.println("Las habilidades de " + this.pokemonActual.getNombre() + " actuales son: ");
        this.pokemonActual.mostrarHabilidades();
    }

    public void mostrarItems() {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Items de " + this.nombre);
        this.items.forEach((k, v) -> v.mostrarItem());
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

    public String getNombrePokemonActual(){
       return this.pokemonActual.getNombre();
    }
}

