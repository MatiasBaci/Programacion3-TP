package view;

import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Habilidad;
import org.fiuba.algoritmos3.HabilidadAtaque;
import org.fiuba.algoritmos3.Pokemon;

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
    }

    public String getNombre(){
        return this.pokemon.getNombre();
    }

    public void mostrarHabilidades() {
        this.habilidadesView.forEach((k, v) -> v.mostrar());
    }

}