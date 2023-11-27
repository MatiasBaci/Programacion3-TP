package orgFiuba.tpjava.Controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.File;

import static orgFiuba.tpjava.Constantes.*;

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
        String path = RUTA_MENU_SPRITES + carpeta + "/" + pokemon.getNombre() + extension;
        Image pokemonImage = new Image(new File(path).toURI().toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        pokemonImageView.setFitHeight(pokemonImage.getHeight()*3);
        pokemonImageView.setFitWidth(pokemonImage.getWidth()*3);
        if (!pokemonEstaVivo) {pokemonImageView.setRotate(180);}
        return pokemonImageView;
    }

    public Text createPokemonName(Pokemon pokemon) {
        Text pokemonName = new Text(pokemon.getNombre());
        pokemonName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pokemonName.setFill(Color.BLACK);
        //pokemonName.setTranslateX(20);
        //pokemonName.setTranslateY(20);
        if (!pokemon.estaConsciente()) {
            pokemonName.setStrikethrough(true);
        }
        return pokemonName;
    }

    public String createCrySFXPath(Pokemon pokemon) {
        return RUTA_SFX_CRIES + pokemon.getNombre() + ".mp3";
    }

    public Node createPokemonStats(Pokemon pokemon) {

        Text pokemonStats = new Text("HP: " + (int)pokemon.getCualidades().getVida() + "\n" +
                "Ataque: " + pokemon.getCualidades().getAtaque() + "\n" +
                "Defensa: " + pokemon.getCualidades().getDefensa() + "\n" +
                "Velocidad: " + pokemon.getCualidades().getVelocidad() + "\n" +
                "Tipo: " + pokemon.getCualidades().getTipo().getNombre() + "\n" +
                "Nivel: " + (int)pokemon.getCualidades().getNivel());
        pokemonStats.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pokemonStats.setFill(Color.BLACK);
        //pokemonStats.setTranslateX(40);
        //pokemonStats.setTranslateX(50);
        return pokemonStats;
    }

    public String createHabilidadSFXPath(Habilidad habilidad) {
        return RUTA_SFX_HABILIDADES + habilidad.getNombre() + ".mp3";
    }
}
