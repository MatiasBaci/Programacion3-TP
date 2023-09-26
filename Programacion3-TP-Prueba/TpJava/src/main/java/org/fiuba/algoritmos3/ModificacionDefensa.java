package org.fiuba.algoritmos3;

public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Estadisticas unaEstadistica,int etapas){
        unaEstadistica.modificarDefensa(etapas);
    }
}
