package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.util.Map;

public class PokemonImageFactory {

    //final static Map <Class, String> pokemonesJugador1 = Map.ofEntries(Map.entry());
    /*final static Map<Class, String> pokemonsJugador1 = Map.ofEntries(
            Map.entry(Pokemon.class, "src/main/resources/orgFiuba/tpjava/Imagenes/pokemon/main-sprites/black-white/pokemonesEjemplo/Frente/pikachu.png"),
            Map.entry(Alfil.class, "imagenes/alfil_negro.png"),
            Map.entry(Torre.class, "imagenes/torre_negro.png")
    );

    final static Map<Class, String> piezasBlancas = Map.ofEntries(
            Map.entry(Caballo.class, "imagenes/caballo_blanco.png"),
            Map.entry(Alfil.class, "imagenes/alfil_blanco.png"),
            Map.entry(Torre.class, "imagenes/torre_blanco.png")
    );

    final static Map<ColoresJugadores, Map<Class, String>> piezas = Map.ofEntries(
            Map.entry(BLANCO, piezasBlancas),
            Map.entry(NEGRO, piezasNegras)
    );
*/


    public ImageView createPokemonImageView(Pokemon pokemon) {
        String path = "Imagenes/pokemonesEjemplo/Frente/pikachu.png";
        Image pokemonImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView pokemonImageView = new ImageView();
        pokemonImageView.setImage(pokemonImage);
        return pokemonImageView;
    }
}
