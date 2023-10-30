package org.fiuba.algoritmos3;

public class ModificacionAtaque implements Modificacion { //implementsModificable


    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarAtaque(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return "Ataque";
    }

}