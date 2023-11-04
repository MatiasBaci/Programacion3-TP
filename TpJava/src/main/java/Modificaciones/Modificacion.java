package Modificaciones;

import Pokemones.Cualidades;

public interface Modificacion {
    public abstract void modificar(Cualidades cualidades, int etapas);

    public abstract String obtenerNombreModificacion();
}
