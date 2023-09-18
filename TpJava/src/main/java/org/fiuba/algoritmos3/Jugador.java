import java.util.ArrayList;
import java.util.List;

public class Jugador {

    //Atributos:

    private List<Pokemon> pokemones;
    private List<Items> items;

    // Metodos:


    public List<Items> getItems() {

        return items;
    }

    public List<Pokemon> getPokemones() {

        return pokemones;
    }

    public void setItems(List<Items> items) {

        this.items = items;
    }

    public void setPokemones(List<Pokemon> pokemones) {

        this.pokemones = pokemones;
    }

}
