package orgFiuba.tpjava.Controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

public class ItemsResourceFactory {


    public ImageView createItemMenuView(Item item) {

        System.out.println(item.getNombre());
        String extension = ".png";
        String carpeta;
        String path = "Imagenes/Items/"   + item.getNombre() + extension;
        Image itemImage = new Image(getClass().getResource("/orgFiuba/tpjava/" + path).toString());
        ImageView itemImageView = new ImageView();
        itemImageView.setImage(itemImage);
        itemImageView.setFitHeight(50);
        itemImageView.setFitWidth(50);
        itemImageView.setTranslateX(20);
        itemImageView.setTranslateY(20);
        return itemImageView;
    }

    public Text createItemName(Item item) {
        Text itemName = new Text(item.getNombre() + " Cantidad:" + item.getCantidad());
        itemName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        itemName.setFill(Color.BLACK);
        itemName.setTranslateX(20);
        itemName.setTranslateY(20);
        return itemName;
    }


   // public Node createPokemonStats(Pokemon pokemon) {
    //    Text pokemonStats = new Text("HP: " + pokemon.getCualidades().getVida() + "\n" +
     //           "Ataque: " + pokemon.getCualidades().getAtaque() + "\n" +
      //          "Defensa: " + pokemon.getCualidades().getDefensa() + "\n" +
      //          "Velocidad: " + pokemon.getCualidades().getVelocidad() + "\n" +
      //          "Tipo: " + pokemon.getCualidades().getTipo().getNombre() + "\n" +
      //          "Nivel: " + pokemon.getCualidades().getNivel());
     //   pokemonStats.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
     //   pokemonStats.setFill(Color.BLACK);
     //   pokemonStats.setTranslateX(40);
      //  pokemonStats.setTranslateY(50);
     //   return pokemonStats;
   // }
}