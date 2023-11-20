package orgFiuba.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;
@JsonTypeName("Hiper Pocion")
public class HiperPocion extends ItemsCuracion {

    public HiperPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        if (this.cantidad > 1) {
            this.cantidad = 1;
        }
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
        this.unaModificacion.modificar(cualidades, 100);
        return realizo;
    }
}

