package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.Controller.Eventos.PokemonSeleccionadoEvent;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SeleccionarPokemonController {

    @FXML
    public HashMap<String, ImageView> pokemonMenuViews;

    public List<Pokemon> pokemones;
    private Jugador jugador;
    private JuegoController juegoController;
    private Item itemAplicar;
    @FXML
    public GridPane gridPanePokemones;

    public void inicializar(Jugador jugador, JuegoController juegoController) {

        juegoController.setSeleccionarPokemonController(this);
        this.juegoController = juegoController;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void actualizarVista(Jugador jugador) {
        try {
            gridPanePokemones.getChildren().clear();
        } catch (Exception ignored) {}

        this.itemAplicar = null;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void actualizarVistaAplicarItem(Jugador jugador, Item itemAplicar) {

        try {
            gridPanePokemones.getChildren().clear();
        } catch (Exception ignored) {}

        this.itemAplicar = itemAplicar;
        this.crearVentanaSeleccionarPokemon(jugador);
    }

    public void crearVentanaSeleccionarPokemon(Jugador jugador) {

        this.jugador = jugador;
        this.pokemonMenuViews = new HashMap<>();
        this.pokemones = new ArrayList<>();
        PokemonResourceFactory pokemonResourceFactory = new PokemonResourceFactory();

        this.jugador.getMisPokemones().forEach((k, v) -> pokemones.add(v));

        HBox pokemonView;
        VBox pokemonStats;
        VBox pokemonIconoYNombre;
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 2; col++) {

                pokemonView = new HBox();
                pokemonStats = new VBox();
                pokemonIconoYNombre = new VBox();

                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonMenuView(pokemones.get(index), pokemones.get(index).estaConsciente()));
                pokemonIconoYNombre.getChildren().add(pokemonResourceFactory.createPokemonName(pokemones.get(index)));

                pokemonStats.getChildren().add(pokemonResourceFactory.createPokemonStats(pokemones.get(index)));

                pokemonView.getChildren().add(pokemonIconoYNombre);
                pokemonView.getChildren().add(pokemonStats);

                if(this.itemAplicar == null){
                    if(pokemones.get(index).estaConsciente()){
                        pokemonView.setOnMouseClicked(createImageViewClickHandler(pokemonView, this.juegoController, this.jugador, pokemones.get(index)));
                    }
                }else{
                    pokemonView.setOnMouseClicked(createImageViewClickHandlerItemAplicar(pokemonView, this.juegoController, this.jugador, pokemones.get(index), this.itemAplicar));
                }

                this.gridPanePokemones.add(pokemonView, col, row);

                index++;
            }
        }
    }

    private EventHandler<? super MouseEvent> createImageViewClickHandlerItemAplicar(HBox imageView, JuegoController juegoController, Jugador jugador, Pokemon pokemon, Item itemAplicar) {
        return event -> {
            if(pokemon.getCualidades().getVida() == 0 && !Objects.equals(itemAplicar.getNombre(), "Revivir")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("El pokemon no tiene vida, no se puede usar este item.");
                alert.showAndWait();
            }
            else if((pokemon.getCualidades().getVida() == pokemon.getCualidades().getVidaMaxima() && itemAplicar.getUnaModificacion().getClass() == ModificacionVida.class)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("El pokemon tiene toda la vida, no se puede curar.");
                alert.showAndWait();
            }
            else if(pokemon.getCualidades().getVida() == pokemon.getCualidades().getVidaMaxima() && Objects.equals(itemAplicar.getNombre(), "Revivir")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("El pokemon tiene toda la vida, no se puede revivir.");
                alert.showAndWait();
            }
            else{
                jugador.elegirItem(itemAplicar.getNombre()).aplicarItem(pokemon.getCualidades());

            }
            try {
                juegoController.handle(new ItemAplicadoEvent(jugador, itemAplicar, pokemon));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Hay que mejorar a forma de volver al menu, lo ideal seria no avanazar a 133 en los casos negayivos
            // y agregar un boton para volver al menu sin consumir turno para no estancase.
            //juegoController.handle(new PokemonSeleccionadoEvent(jugador, pokemon)); // Replace yourFunction with the actual function name

        };

    }

    // Create an event handler for ImageView click events
    private EventHandler<MouseEvent> createImageViewClickHandler(HBox imageView, JuegoController juegoController, Jugador jugador, Pokemon pokemon) {
        return event -> {
            System.out.println("ImageView clicked! " + imageView.getId());
            if(pokemon.getCualidades().getVida() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("El pokemon no tiene vida, no se puede elegir.");
                alert.showAndWait();
            }else{
                juegoController.handle(new PokemonSeleccionadoEvent(jugador, pokemon));
            }
        };
    }
}
