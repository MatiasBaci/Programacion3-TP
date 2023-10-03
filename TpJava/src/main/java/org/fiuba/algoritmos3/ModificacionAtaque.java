package org.fiuba.algoritmos3;

public class ModificacionAtaque implements Modificacion { //implementsModificable


    @Override
    public void modificar(Estadisticas unaEstadistica, int etapas) {
        if (unaEstadistica.getVida() != 0) {
            unaEstadistica.modificarAtaque(etapas);
        } else if (unaEstadistica.getVida() == 0) {
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede modificar su ataque.");
        }
    }

}