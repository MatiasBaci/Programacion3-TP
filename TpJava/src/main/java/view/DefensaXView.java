package view;
import Item.*;

public class DefensaXView extends ItemView{

    public DefensaXView(Item item){
        super(item);

    }

    public void mostrar(){

        System.out.println(this.item.getNombre() + ": Aumenta 10% la defensa - Cantidad: " + this.item.getCantidad());

    }
}
