package orgFiuba.Model.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Cualidades;
@JsonTypeName("Revivir")
public class Revivir extends ItemsEstado {

    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Cualidades cualidades) {

        boolean realizo = this.realizarUsadoRevivir(cualidades.obtenerEstadosActuales());
        this.unaModificacion.modificar(cualidades, (int) cualidades.getVidaMaxima());
        return realizo;
    }

}
