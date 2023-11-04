package Modificaciones;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_DEFENSA;

public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarDefensa(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_DEFENSA;
    }
}
