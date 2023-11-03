package view.ItemsView;

import Item.Item;

import static org.fiuba.algoritmos3.Constantes.ANSI_GRISCLARO;
import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;

public class DefensaXView extends ItemView{

    public DefensaXView(Item item){
        super(item);

    }

    public void mostrar(){

        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET + ": Aumenta 10% la defensa - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);

    }
}
