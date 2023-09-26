package org.fiuba.algoritmos3;

public class ModificacionVida implements Modificacion{

    @Override
    public void modificar(Estadisticas estadisticas, int etapas) {
        estadisticas.aumentarVida(etapas);
    }
}
