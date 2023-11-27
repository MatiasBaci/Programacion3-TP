package orgFiuba.tpjava.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionarItemController {

    @FXML
    public HashMap<String, ImageView> itemsViews;

    @FXML
    public VBox vboxMenuItems;

    public List<Item> items;
    private Jugador jugador;
    private JuegoController juegoController;
    @FXML
    public GridPane gridPaneItems;
    @FXML
    public Text descripcionItem;

    public void inicializar(Jugador jugador, JuegoController juegoController) throws IOException {
        juegoController.setSeleccionarItemController(this);
        this.juegoController = juegoController;
        this.crearVentanaMenuItem(jugador);

    }

    public void crearVentanaMenuItem(Jugador jugador){

        this.jugador = jugador;
        this.itemsViews = new HashMap<>();
        this.items = new ArrayList<>();
        ItemsResourceFactory itemsResourceFactory = new ItemsResourceFactory();

        this.jugador.getItems().forEach((k, v) -> items.add(v));

        HBox itemsView;
        HBox itemIconoYNombre;
        int index = 0;

        for (int row = 0; row < 8; row++) {

            Item item = items.get(index);
            itemsView = new HBox();
            itemIconoYNombre = new HBox();

            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemMenuView(item));
            itemIconoYNombre.getChildren().add(itemsResourceFactory.createItemData(item));
            itemIconoYNombre.setTranslateX(70);


            itemsView.getChildren().add(itemIconoYNombre);

            itemsView.setOnMouseClicked(createImageViewClickHandler(itemsView, this.juegoController, this.jugador, item));

            itemsView.setOnMouseEntered(event -> {
                descripcionItem.setText(item.getDescripcion());
            });

            itemsView.setOnMouseExited(event -> {
                descripcionItem.setText("");
            });

            gridPaneItems.add(itemsView, 0, row);

            index++;
        }
    }

    // Create an event handler for ImageView click events
    private EventHandler<MouseEvent> createImageViewClickHandler(HBox imageView, JuegoController juegoController, Jugador jugador, Item item) {
        return event -> {
            System.out.println("ItemView clicked! " + imageView.getId());

            // Call a function from your object
            try {
                juegoController.handle(new MenuItemEvent(jugador)); // Replace yourFunction with the actual function name
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Add your additional event handling code here
        };
    }

    public void actualizarVista(Jugador jugador) {
        try {
            gridPaneItems.getChildren().clear();
        } catch (Exception ignored) {}

        this.crearVentanaMenuItem(jugador);
    }
}



