package org.fiuba.algoritmos3;

public class ModificacionVida implements Modificacion{

    @Override
    public void modificar(Estadisticas estadisticas, int etapas) {

        if(estadisticas.getVida() != estadisticas.getVidaMaxima() && estadisticas.getVida() != 0){
            estadisticas.aumentarVida(etapas);
        } else if (estadisticas.getVida() == 0){
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede curar.");
        } else if (estadisticas.getVida() == estadisticas.getVidaMaxima()){
            System.out.println(" ");
            System.out.println("El Pokemon tiene toda la vida, no se puede curar.");
        }
    }

}
