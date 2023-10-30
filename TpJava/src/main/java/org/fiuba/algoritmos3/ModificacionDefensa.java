package org.fiuba.algoritmos3;

public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if (unaCualidad.getVida() != 0) {
            unaCualidad.modificarDefensa(etapas);
        }
    }
    public String obtenerNombreModificacion(){
        return "Defensa";
    }
}
