package org.fiuba.algoritmos3;

public class ModificacionVida implements Modificacion{

    @Override
    public void modificar(Cualidades cualidades, int etapas) {

        if(cualidades.getVida() != cualidades.getVidaMaxima() && cualidades.getVida() != 0){
            cualidades.aumentarVida(etapas);
        }
        else if (cualidades.getVida() == cualidades.getVidaMaxima()) {

            System.out.println(" ");
            System.out.println("El Pokemon tiene toda la vida, no se puede curar.");
        }

    }
    public String obtenerNombreModificacion(){
        return "Vida";
    }

}
