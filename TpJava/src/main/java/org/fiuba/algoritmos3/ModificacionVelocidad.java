package org.fiuba.algoritmos3;

public class ModificacionVelocidad implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarVelocidad(etapas);
        } else if (unaCualidad.getVida() == 0) {
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede modificar su velocidad.");
        }
    }
    public String obtenerNombreModificacion(){
        return "Velocidad";
    }
}
