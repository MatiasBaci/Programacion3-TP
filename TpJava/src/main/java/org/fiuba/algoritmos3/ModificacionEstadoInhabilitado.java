package org.fiuba.algoritmos3;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Estadisticas estadisticas, int etapas) {
        estadisticas.aumentarVida(etapas);
    }


}
