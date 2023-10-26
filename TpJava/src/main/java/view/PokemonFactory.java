package view;

import Item.Item;
import org.fiuba.algoritmos3.Pokemon;

public class PokemonFactory {

    public PokemonView createPokemonView(Pokemon pokemon) {

        return new PokemonView(pokemon);
    }
}
