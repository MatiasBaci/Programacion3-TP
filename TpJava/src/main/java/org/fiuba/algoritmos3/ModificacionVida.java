package org.fiuba.algoritmos3;

import static org.fiuba.algoritmos3.Constantes.MODIFICACION_VIDA;

public class ModificacionVida implements Modificacion{

    @Override
    public void modificar(Cualidades cualidades, int etapas) {

        if(cualidades.getVida() != cualidades.getVidaMaxima() && cualidades.getVida() != 0){
            cualidades.aumentarVida(etapas);
        }

    }
    public String obtenerNombreModificacion(){
        return MODIFICACION_VIDA;
    }

}
