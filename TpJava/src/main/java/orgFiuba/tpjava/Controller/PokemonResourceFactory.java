package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class PokemonResourceFactory {

    public ImageView createPokemonBattleView(Pokemon pokemon, String cara) { //cara puede ser "Frente" o "Espalda"
        String path = "Imagenes/Pokemon/Battle Sprites/" + cara + "/" + pokemon.getNombre() + ".gif";
        Image pokemonImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        return pokemonImageView;
    }

    public ImageView createPokemonMenuView(Pokemon pokemon, Boolean pokemonEstaVivo) {
        String extension;
        String carpeta;
        if (pokemonEstaVivo) {
            extension = ".gif";
            carpeta = "Animadas";
        } else {
            extension = ".png";
            carpeta = "Estaticas";
        }
        String path = "Imagenes/Pokemon/Menu Sprites/" + carpeta + "/" + pokemon.getNombre() + extension;
        Image pokemonImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        return pokemonImageView;
    }

    public Media createPokemonCry(Pokemon pokemon) {
        String path = "Sonidos/Sonido/Cries/" + pokemon.getNombre() + ".mp3";
        Media pokemonCry = new Media(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        return pokemonCry;
    }
}
