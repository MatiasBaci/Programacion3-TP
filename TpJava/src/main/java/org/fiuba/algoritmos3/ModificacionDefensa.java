package org.fiuba.algoritmos3;

public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarDefensa(etapas);
        } else if (unaCualidad.getVida() == 0) {
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede modificar su defensa.");
        }
    }
    public String obtenerNombreModificacion(){
        return "Defensa";
    }
}
