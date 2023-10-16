package Item;

import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Cualidades;

public class Pocion extends ItemsCuracion {

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }
    @Override
    public boolean aplicarItem(Cualidades cualidades){

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 25);
        return realizo;
    }

    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 25 de vida - Cantidad: " + cantidad);
    }
}
