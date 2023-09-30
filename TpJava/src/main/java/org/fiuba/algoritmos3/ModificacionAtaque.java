package org.fiuba.algoritmos3;

public class ModificacionAtaque implements Modificacion{ //implementsModificable


    @Override
    public void modificar(Estadisticas unaEstadistica,int etapas){
        unaEstadistica.modificarAtaque(etapas);
    }
}
