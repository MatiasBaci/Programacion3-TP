package view;
import Item.*;

public class MegaPocionView extends ItemView{

    public MegaPocionView(Item item){
        super(item);

    }

    public void mostrar(){
        System.out.println(this.item.getNombre() + ": Restaura 50 de vida - Cantidad: " + this.item.getCantidad());
    }
}
