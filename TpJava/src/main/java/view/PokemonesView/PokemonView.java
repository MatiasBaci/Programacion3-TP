package view.PokemonesView;

import Pokemones.Habilidad;
import Pokemones.Pokemon;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

public class PokemonView {

    private Pokemon pokemon;
    private CualidadesView cualidadesView;

    private CualidadesFactory cualidadesFactory;

    private Map<String, HabilidadView> habilidadesView;

    private HabilidadFactory habilidadFactory;


    public PokemonView(Pokemon pokemon){

        this.pokemon = pokemon;
        this.cualidadesFactory = new CualidadesFactory();
        this.cualidadesView = cualidadesFactory.createCualidadesView(pokemon.getCualidades());
        this.habilidadesView = new HashMap<String, HabilidadView>();
        this.habilidadFactory = new HabilidadFactory();
        pokemon.getMisHabilidades().forEach((k, v) -> habilidadesView.put(k, this.habilidadFactory.createHabilidadView(v)));
    }

    public void mostrar(){
        System.out.println(" Nombre: " + this.pokemon.getNombre());
        this.cualidadesView.mostrar();
        System.out.println(" Historia: " + this.pokemon.getHistoria());
        System.out.println("\n");
    }

    public Tipo getTipoPokemon(){
        return this.pokemon.getTipo();
    }

    public String getNombre(){
        return this.pokemon.getNombre();
    }

    public void mostrarHabilidades() {
        this.habilidadesView.forEach((k, v) -> v.mostrar());
    }

    private void mostrarUsoDeHabilidad(String nombrePokemon, String nombreHabilidad){
        System.out.println("¡"+ nombrePokemon + " uso " + nombreHabilidad + "!");
        System.out.println("\n");
    }

    public void mostrarCasoSePuedeAtacar(Pokemon pokemon, Pokemon pokemonEnemigo, Habilidad habilidad){

        HabilidadView habilidadViewAux = this.habilidadFactory.createHabilidadView(habilidad);

        if (this.cualidadesView.atacarConEstadosActuales()){
            this.mostrarUsoDeHabilidad(pokemon.getNombre(), habilidad.getNombre());
            habilidadViewAux.mostrarUsarHabilidad(pokemonEnemigo.getCualidades(), pokemon.getCualidades());
        }
    }

    public void mostrarEfectoPasivo(){
        this.cualidadesView.getEstadosActualesView().forEach(estadoView -> estadoView.mostrarEfectoPasivoDeEstado());
    }
}