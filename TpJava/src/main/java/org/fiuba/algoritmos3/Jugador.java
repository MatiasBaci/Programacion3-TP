package org.fiuba.algoritmos3;
// import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Jugador {

    //Atributos:
    private String nombre;

    private Map<String, Pokemon> misPokemones;
    private List<Items> items;

    private Pokemon pokemonActual;

    private Jugador adversario;
    private boolean atacante; //Si es atacante es su turno.
    private boolean ganoJuego;  //True si gano el juego

    // Metodos:

    public Jugador(String nombre, Map<String, Pokemon> misPokemones, List<Items> items) {
        this.nombre = nombre;
        this.misPokemones = misPokemones;
        this.items = items;
        this.atacante = false;
    }

    public List<Items> getItems() {
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

    public void mostratHabilidadesPokemonActual(){

        System.out.println("Las habilidades de " + pokemonActual.getNombre() + " actuales son: ");
        pokemonActual.mostrarHabilidades();

    }
    public void aplicarEfectoPasivo(Pokemon unPokemon){
        unPokemon.aplicarEfectoPasivoPokemon(pokemonActual);
    }

    public void atacarJugador(Jugador jugadorAdversario, String nombreHabilidad){

        boolean validarHabilidad =this.pokemonActual.validarHabilidar(nombreHabilidad);

        if(validarHabilidad) {
            if(!Objects.equals(pokemonActual.suEstadoEs(), "Dormido")) {
                pokemonActual.atacar(jugadorAdversario.getPokemonActual(), nombreHabilidad);

            }else{
                pokemonActual.atacarTurnoPerdido(pokemonActual);

            }
            setAtacante(false);

        }


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

}


