package view;
import Item.*;

public class PocionView extends ItemView{

    public PocionView(Item item){
        super(item);
    }

    public void mostrar() {
        System.out.println(this.item.getNombre() + ": Restaura 25 de vida - Cantidad: " + this.item.getCantidad());
    }
}
