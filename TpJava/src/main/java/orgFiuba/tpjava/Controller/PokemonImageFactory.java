package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.Map;

public class PokemonImageFactory {

    public ImageView createPokemonImageView(Pokemon pokemon, String cara) { //cara puede ser "Frente" o "Espalda"
        String path = "Imagenes/pokemonesEjemplo/" + cara + "/" + pokemon.getNombre() + ".gif";
        Image pokemonImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        return pokemonImageView;
    }
}
