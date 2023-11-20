package orgFiuba.Model.SerializacionDeserealizacion;

import orgFiuba.Model.Items.Item;


public class ItemsIdsCustom {
    private int id;
    private Item unItem;

    public ItemsIdsCustom(int id, Item unItem) {
        this.id = id;
        this.unItem = unItem;
    }

    public int getId() {return this.id ;}

    public Item getUnItem() {return this.unItem;}
    public void setId(int id) {this.id = id;}

    public void setUnPokemon(Item unItem) {this.unItem = unItem;}

}
