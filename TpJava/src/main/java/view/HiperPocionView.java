package view;
import Item.*;

public class HiperPocionView extends ItemView{

    public HiperPocionView(Item item){
        super(item);
    }

    public void mostrar() {

        System.out.println(this.item.getNombre() + ": Restaura 100 de vida - Cantidad: " + this.item.getCantidad());
    }


}
