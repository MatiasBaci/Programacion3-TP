package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AplicarItemController {

    @FXML
    public HashMap<String, ImageView> itemsViews;

    public List<Item> items;
    private Jugador jugador;
    private JuegoController juegoController;
    @FXML
    public GridPane gridPaneItems;

    public void inicializar(Jugador jugador, JuegoController juegoController) throws IOException {
        this.jugador = jugador;
        this.juegoController = juegoController;
        this.itemsViews = new HashMap<>();
        this.items = new ArrayList<>();
        ItemsResourceFactory itemsResourceFactory = new ItemsResourceFactory();

        this.jugador.getItems().forEach((k, v) -> items.add(v));

        HBox itemsView;
        VBox itemIconoYNombre;
        int index = 0;

        for (int row = 0; row < 8; row++) {

            itemsView = new HBox();
            itemIconoYNombre = new VBox();

            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemMenuView(items.get(index)));
            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemName(items.get(index)));

            itemsView.getChildren().add(itemIconoYNombre);

            itemsView.setOnMouseClicked(createImageViewClickHandler(itemsView, this.juegoController, this.jugador, items.get(index)));

            gridPaneItems.add(itemsView, 0, row);

            index++;

        }
    }

    // Create an event handler for ImageView click events
    private EventHandler<MouseEvent> createImageViewClickHandler(HBox imageView, JuegoController juegoController, Jugador jugador, Item item) {
        return event -> {
            System.out.println("ItemView clicked! " + imageView.getId());

            // Call a function from your object
            juegoController.handle(new AplicarItemeEvent(jugador, item)); // Replace yourFunction with the actual function name

            // Add your additional event handling code here
        };
    }
}



