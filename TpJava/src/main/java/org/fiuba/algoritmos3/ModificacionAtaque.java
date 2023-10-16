package org.fiuba.algoritmos3;

public class ModificacionAtaque implements Modificacion { //implementsModificable


    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarAtaque(etapas);
        } else if (unaCualidad.getVida() == 0) {
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede modificar su ataque.");
        }
    }
    public String obtenerNombreModificacion(){
        return "Ataque";
    }

}