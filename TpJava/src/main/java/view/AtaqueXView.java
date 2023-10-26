package view;
import Item.*;

public class AtaqueXView extends ItemView{

    public AtaqueXView(Item item) {
        super(item);
    }

    public void mostrar(){

        System.out.println(item.getNombre() + ": Aumenta 10% el ataque - Cantidad: " + item.getCantidad());

    }
}
