package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonResourceFactory {

    public ImageView createPokemonImageView(Pokemon pokemon, String cara) { //cara puede ser "Frente" o "Espalda"
        String path = "Imagenes/pokemonesEjemplo/" + cara + "/" + pokemon.getNombre() + ".gif";
        Image pokemonImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        return pokemonImageView;
    }

    public Media createPokemonCry(Pokemon pokemon) {
        String path = "Sonidos/pokemonesEjemplo/" + pokemon.getNombre() + ".mp3";
        Media pokemonCry = new Media(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        return pokemonCry;
    }
}
