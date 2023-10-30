package org.fiuba.algoritmos3;

public class ModificacionVelocidad implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarVelocidad(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return "Velocidad";
    }
}
