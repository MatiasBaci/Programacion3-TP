package view.PokemonesView;

import Pokemones.Pokemon;

public class PokemonFactory {

    public PokemonView createPokemonView(Pokemon pokemon) {

        return new PokemonView(pokemon);
    }
}
