package orgFiuba.tpjava.Controller;

import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import orgFiuba.tpjava.Model.Pokemones.*;

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

        return "HP: " + (int)unPokemon.getCualidades().getVida() + "\n" +
                "Lv " +(int)unPokemon.getCualidades().getNivel()+ "\n" +
                unPokemon.getNombre() + "\n"+  todosLosEstados;
    }

    public String createHabilidadSFXPath(Habilidad habilidad) {
        return RUTA_SFX_HABILIDADES + habilidad.getNombre() + ".mp3";
    }

    public Image createClimaOverlay(String clima) throws FileNotFoundException {
        Image backgroundImage = null;
        backgroundImage = new Image(new File(RUTA_CLIMAS + clima + ".gif").toURI().toString());
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

    public Pane generarBotonAtaque(Habilidad habilidad) {
        Pane ataque = new Pane();
        ataque.setPrefHeight(100);
        ataque.setPrefWidth(200);
        ataque.setStyle("-fx-font-size: 18px");
        ataque.setNodeOrientation(NodeOrientation.INHERIT);
        ataque.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-background-insets: 0px; -fx-padding: 5px;");
        /*Text texto = new Text(habilidad.getNombre());
        texto.setTextAlignment(TextAlignment.CENTER);
        ataque.getChildren().add(texto);*/
        agregarIconos(ataque, habilidad);
        return ataque;
    }

    private void agregarIconos(Pane ataque, Habilidad habilidad) {
        if (habilidad.getClass().equals(HabilidadAtaque.class)) {
            agregarIconosAtaque(ataque, (HabilidadAtaque) habilidad);
        } else if (habilidad.getClass().equals(HabilidadEstadistica.class)) {
            agregarIconosEstadistica(ataque, (HabilidadEstadistica) habilidad);
        } else if (habilidad.getClass().equals(HabilidadEstado.class)) {
            agregarIconosEstado(ataque, (HabilidadEstado) habilidad);
        } else if (habilidad.getClass().equals(HabilidadClima.class)) {
            agregarIconosClima(ataque, (HabilidadClima) habilidad);
        }
    }

    private void agregarIconosClima(Pane ataque, HabilidadClima habilidad) {

        VBox ataqueVBox = crearVBoxParaHabilidad(ataque);

        ImageView iconoClima = new ImageView();
        String rutaIcono = RUTA_ICONOS + "clima.png";
        iconoClima.setImage(new Image(new File(rutaIcono).toURI().toString()));
        iconoClima.setFitWidth(20);
        iconoClima.setFitHeight(20);
        iconoClima.setTranslateX(50);
        iconoClima.setTranslateY(8);
        ataqueVBox.getChildren().add(iconoClima);

        Text texto = new Text(habilidad.getNombre());
        texto.setText(texto.getText() +
                "\nClima: " + habilidad.getClimaNombre() +
                "\nPP: " + habilidad.getCantidadDeUsos());
        texto.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        texto.setTextAlignment(TextAlignment.LEFT);
        texto.setLineSpacing(0);
        texto.setTranslateX(10);
        texto.setTranslateY(10);
        ataqueVBox.getChildren().add(texto);

        ataque.getChildren().add(ataqueVBox);
    }

    private void agregarIconosEstado(Pane ataque, HabilidadEstado habilidad) {

        VBox ataqueVBox = crearVBoxParaHabilidad(ataque);

        ImageView iconoEstado = new ImageView();
        String rutaIcono = RUTA_ICONOS + "Estados/" + habilidad.getEstado().getNombre() + ".png";
        iconoEstado.setImage(new Image(new File(rutaIcono).toURI().toString()));
        iconoEstado.setFitWidth(20);
        iconoEstado.setFitHeight(20);
        iconoEstado.setTranslateX(50);
        iconoEstado.setTranslateY(8);
        ataqueVBox.getChildren().add(iconoEstado);

        Text texto = new Text(habilidad.getNombre());
        texto.setText(texto.getText() +
                "\nEstado: " + habilidad.getEstado().getNombre() +
                "\nPP: " + habilidad.getCantidadDeUsos());
        texto.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        texto.setTextAlignment(TextAlignment.LEFT);
        texto.setLineSpacing(0);
        texto.setTranslateX(10);
        texto.setTranslateY(10);
        ataqueVBox.getChildren().add(texto);

        ataque.getChildren().add(ataqueVBox);
    }

    private void agregarIconosEstadistica(Pane ataque, HabilidadEstadistica habilidad) {

        VBox ataqueVBox = crearVBoxParaHabilidad(ataque);

        ImageView iconoEstadistica = new ImageView();
        String rutaIcono = RUTA_ICONOS + "Estadisticas/" + habilidad.getModificacion() + ".png";
        iconoEstadistica.setImage(new Image(new File(rutaIcono).toURI().toString()));
        iconoEstadistica.setFitWidth(20);
        iconoEstadistica.setFitHeight(20);
        iconoEstadistica.setTranslateX(50);
        iconoEstadistica.setTranslateY(8);
        ataqueVBox.getChildren().add(iconoEstadistica);

        Text texto = new Text(habilidad.getNombre());
        texto.setText(texto.getText() +
                "\nEfecto: " + habilidad.getModificacion() +
                "\nPP: " + habilidad.getCantidadDeUsos());
        texto.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        texto.setTextAlignment(TextAlignment.LEFT);
        texto.setLineSpacing(0);
        texto.setTranslateX(10);
        texto.setTranslateY(10);
        ataqueVBox.getChildren().add(texto);

        ataque.getChildren().add(ataqueVBox);
    }

    private void agregarIconosAtaque(Pane ataque, HabilidadAtaque habilidad) {

        VBox ataqueVBox = crearVBoxParaHabilidad(ataque);

        ImageView iconoAtaque = new ImageView();
        String rutaIcono = RUTA_ICONOS + "Tipos/" + habilidad.getTipo().getNombre() + ".png";
        iconoAtaque.setImage(new Image(new File(rutaIcono).toURI().toString()));
        iconoAtaque.setFitWidth(100);
        iconoAtaque.setFitHeight(20);
        iconoAtaque.setTranslateX(50);
        iconoAtaque.setTranslateY(8);
        ataqueVBox.getChildren().add(iconoAtaque);

        Text texto = new Text(habilidad.getNombre());
        texto.setText(texto.getText() +
                "\nPoder: " + habilidad.getPoder() +
                "\nPP: " + habilidad.getCantidadDeUsos());
        texto.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        texto.setTextAlignment(TextAlignment.LEFT);
        texto.setLineSpacing(0);
        texto.setTranslateX(10);
        texto.setTranslateY(10);
        ataqueVBox.getChildren().add(texto);

        ataque.getChildren().add(ataqueVBox);
    }

    private VBox crearVBoxParaHabilidad(Pane panelHabilidad) {
        VBox ataqueVBox = new VBox();
        ataqueVBox.setPrefWidth(panelHabilidad.getPrefWidth());
        ataqueVBox.setPrefHeight(panelHabilidad.getPrefHeight());
        return ataqueVBox;
    }
}
