package Item;

import Modificaciones.Modificacion;
import Pokemones.Cualidades;

public class PocionMolestaAlumnos extends ItemsCuracion{
    public PocionMolestaAlumnos(String unNombre, int cantidad, Modificacion unModificacion) {
        super(unNombre, cantidad);
        this.unaModificacion = unModificacion;
    }

    @Override
    public boolean aplicarItem(Cualidades cualidades) {
            boolean realizo = realizarUsadoItemsDeCuracion(cualidades);
            this.unaModificacion.modificar(cualidades, (int)Math.round(cualidades.getVidaMaxima()/3)); // --> 1/3 de la vida maxima del pokemon al que lo desea aplicar
            return realizo;
    }
}
