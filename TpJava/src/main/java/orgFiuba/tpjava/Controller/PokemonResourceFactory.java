package orgFiuba.tpjava.Controller;

import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return getImageView(pokemonEstaVivo, pokemonImage);
    }

    private static ImageView getImageView(Boolean pokemonEstaVivo, Image pokemonImage) {
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        pokemonImageView.setFitHeight(pokemonImage.getHeight()*3);
        pokemonImageView.setFitWidth(pokemonImage.getWidth()*3);

        pokemonImageView.setTranslateX(30);
        pokemonImageView.setTranslateY(30);

        if (!pokemonEstaVivo) {
            //pokemonImageView.setRotate(180);
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setSaturation(-1); // Set saturation to -1 for grayscale
            pokemonImageView.setEffect(colorAdjust);
        }
        return pokemonImageView;
    }

    public Text createPokemonName(Pokemon pokemon) {
        Text pokemonName = new Text(pokemon.getNombre());
        pokemonName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pokemonName.setFill(Color.BLACK);
        pokemonName.setTranslateX(30);
        pokemonName.setTranslateY(30);
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
        pokemonStats.setTranslateX(80);
        pokemonStats.setTranslateY(30);
        return pokemonStats;
    }
    public String  createBatallaStats(Pokemon unPokemon){

        List<String> estados = new ArrayList<>();
        unPokemon.getCualidades().obtenerEstadosActuales().forEach(x -> estados.add(x.getNombre()));
        StringBuilder todosLosEstados = new StringBuilder("Estados: ");
        for (String unEstado : estados){
            if(!Objects.equals(unEstado, "Normal")){
                todosLosEstados.append(unEstado).append(" ");
            }
        }
        String unTextoCompleto =  "HP: " + (int)unPokemon.getCualidades().getVida() + "\n" +
                "Lv " +(int)unPokemon.getCualidades().getNivel()+ "\n" +
                unPokemon.getNombre() + "\n"+  todosLosEstados;

        return  unTextoCompleto;
    }

    public String createHabilidadSFXPath(Habilidad habilidad) {
        return RUTA_SFX_HABILIDADES + habilidad.getNombre() + ".mp3";
    }

    public Image createClimaOverlay(String clima) throws FileNotFoundException {
        Image backgroundImage = null;
        String path;
        // Load the image
        try {
            path = RUTA_CLIMAS + clima + ".gif";
            backgroundImage = new Image(new File(path).toURI().toString());
        } catch (Exception e) {
            try {
                path = RUTA_CLIMAS + clima + ".png";
                backgroundImage = new Image(new File(path).toURI().toString());
            } catch (Exception e2) {
                throw new FileNotFoundException();
            }
        }
        // Create a BackgroundImage
       /*BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );*/
        return backgroundImage;
    }

    public ImageView getPokeball(Pokemon unPokemon) {
        Image unaImagen = new Image(new File(RUTA_ICONO_POKEBALL).toURI().toString());
        ImageView unaPokeballView = new ImageView();
        unaPokeballView.setImage(unaImagen);

        unaPokeballView.setFitHeight(24);
        unaPokeballView.setFitWidth(24);
        if(!unPokemon.estaConsciente()){
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setSaturation(-1); // Set saturation to -1 for grayscale
            unaPokeballView.setEffect(colorAdjust);
        }

        return unaPokeballView;

    }
}
