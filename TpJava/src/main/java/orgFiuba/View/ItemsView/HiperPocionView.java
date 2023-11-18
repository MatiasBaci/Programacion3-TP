package orgFiuba.View.ItemsView;

import orgFiuba.Model.Items.Item;

import static orgFiuba.Constantes.ANSI_GRISCLARO;
import static orgFiuba.Constantes.ANSI_RESET;

public class HiperPocionView extends ItemView{

    public HiperPocionView(Item item){
        super(item);
    }

    public void mostrar() {

        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET + ": Restaura 100 de vida - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);
    }


}
