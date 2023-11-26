package orgFiuba.tpjava.Controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        pokemonImageView.setFitHeight(100);
        pokemonImageView.setFitWidth(100);
        return pokemonImageView;
    }

    public Text createPokemonName(Pokemon pokemon) {
        Text pokemonName = new Text(pokemon.getNombre());
        pokemonName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pokemonName.setFill(Color.BLACK);
        return pokemonName;
    }

    public Media createPokemonCry(Pokemon pokemon) {
        String path = "Sonidos/Sonido/Cries/" + pokemon.getNombre() + ".mp3";
        Media pokemonCry = new Media(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        return pokemonCry;
    }

    public Node createPokemonStats(Pokemon pokemon) {
        Text pokemonStats = new Text("HP: " + pokemon.getCualidades().getVida() + "\n" +
                "Ataque: " + pokemon.getCualidades().getAtaque() + "\n" +
                "Defensa: " + pokemon.getCualidades().getDefensa() + "\n" +
                "Velocidad: " + pokemon.getCualidades().getVelocidad() + "\n" +
                "Tipo: " + pokemon.getCualidades().getTipo().getNombre() + "\n" +
                "Nivel: " + pokemon.getCualidades().getNivel());
        pokemonStats.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pokemonStats.setFill(Color.BLACK);
        return pokemonStats;
    }
}
