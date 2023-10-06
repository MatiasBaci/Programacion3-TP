package org.fiuba.algoritmos3;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Estadisticas estadisticas, int etapas) {
        if(estadisticas.getVida() == 0) {
            estadisticas.aumentarVida(etapas);
        }else{
            System.out.println(" ");
            System.out.println("El Pokemon no se puede revivir ya que no esta Inhabilitado");
        }

    }

    @Override
    public String obtenerNombreModificacion() {
        return "Inhabilitado";
    }
}
