package view.ItemsView;
import Item.*;

import static org.fiuba.algoritmos3.Constantes.ANSI_GRISCLARO;
import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;


public class PocionCuracionEstadosView extends ItemView{

    public PocionCuracionEstadosView(Item item){
        super(item);
    }

    public void mostrar(){
        System.out.println(ANSI_GRISCLARO + this.item.getNombre() + ANSI_RESET + ": Elimina los Estado del pokemon - Cantidad: " + ANSI_GRISCLARO + this.item.getCantidad() + ANSI_RESET);
    }


}
