package org.fiuba.algoritmos3;

public class ModificacionVelocidad implements Modificacion{
    @Override
    public void modificar(Estadisticas unaEstadistica,int etapas){
        unaEstadistica.modificarVelocidad(etapas);
    }
}
