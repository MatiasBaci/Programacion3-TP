package orgFiuba.tpjava.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Items.Item;

public class ItemsResourceFactory {


    public ImageView createItemMenuView(Item item) {

        String extension = ".png";
        String path = "Imagenes/Items/"   + item.getNombre() + extension;
        Image itemImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView itemImageView = new ImageView();
        itemImageView.setImage(itemImage);
        itemImageView.setFitHeight(50);
        itemImageView.setFitWidth(50);
        itemImageView.setTranslateY(20);
        return itemImageView;
    }

    public Text createItemData(Item item) {
        Text itemData = new Text(item.getNombre() +" | " + " X " + item.getCantidad());
        itemData.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        itemData.setFill(Color.BLACK);
        itemData.setTranslateX(50);
        itemData.setTranslateY(50);
        return itemData;
    }


}