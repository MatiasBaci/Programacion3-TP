package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonIdsCustom {
    private int id;
    private Pokemon unPokemon;

    public PokemonIdsCustom(int id, Pokemon unaPokemon) {
        this.id = id;
        this.unPokemon = unaPokemon;
    }

    public int getId() {return this.id ;}

    public Pokemon getUnaHabilida() {return this.unPokemon;}
    public void setId(int id) {this.id = id;}

    public void setUnPokemon(Pokemon unPokemon) {this.unPokemon = unPokemon;}

}
