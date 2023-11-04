package Modificaciones;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_ATAQUE;

public class ModificacionAtaque implements Modificacion {


    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.estaConsciente()) {
            unaCualidad.modificarAtaque(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_ATAQUE;
    }

}