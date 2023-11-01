package view;
import Item.*;

public abstract class ItemView {

    protected Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    public abstract void mostrar();
}
