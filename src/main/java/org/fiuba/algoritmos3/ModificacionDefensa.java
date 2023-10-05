package org.fiuba.algoritmos3;

public class ModificacionDefensa implements Modificacion{
    @Override
    public void modificar(Estadisticas unaEstadistica, int etapas) {
        if (unaEstadistica.getVida() != 0) {
            unaEstadistica.modificarDefensa(etapas);
        } else if (unaEstadistica.getVida() == 0) {
            System.out.println(" ");
            System.out.println("El Pokemon esta Inhabilitado, no se puede modificar su defensa.");
        }
    }
    public String obtenerNombreModificacion(){
        return "Defensa";
    }
}
