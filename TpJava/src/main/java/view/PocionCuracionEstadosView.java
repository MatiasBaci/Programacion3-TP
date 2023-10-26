package view;
import Item.*;


public class PocionCuracionEstadosView extends ItemView{

    public PocionCuracionEstadosView(Item item){
        super(item);
    }

    public void mostrar(){
        System.out.println(this.item.getNombre() + ": Elimina los Estado del pokemon - Cantidad: " + this.item.getCantidad());
    }


}
