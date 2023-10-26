package view;
import Item.*;

public class RevivirView extends ItemView{

    public RevivirView(Item item){
        super(item);
    }

    public void mostrar() {
        System.out.println(this.item.getNombre() + ": Revive al pokemon con toda su salud - Cantidad: " + this.item.getCantidad());
    }
}
