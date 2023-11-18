package orgFiuba.View.ItemsView;

import orgFiuba.Model.Items.Item;

import static orgFiuba.Constantes.ANSI_GRISCLARO;
import static orgFiuba.Constantes.ANSI_RESET;

public class RevivirView extends ItemView{

    public RevivirView(Item item){
        super(item);
    }

    public void mostrar() {
        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET + ": Revive al pokemon con toda su salud - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);
    }
}
