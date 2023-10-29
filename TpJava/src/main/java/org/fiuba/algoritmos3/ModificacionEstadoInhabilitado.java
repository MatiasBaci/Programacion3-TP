package org.fiuba.algoritmos3;

public class ModificacionEstadoInhabilitado implements Modificacion{

    @Override
    public void modificar(Cualidades unaCualidad, int etapas) {
        if(!unaCualidad.estaConsciente()){
            //unaCualidad.cambiarseEstado(new EstadoNormal()); // cambiar esto, cambiarLosEstadosA-> CASOdonde revivr se le quita los estados
            unaCualidad.cambiarLosEstadosA(new EstadoNormal());
        }
        if(unaCualidad.getVida() == 0) {
            unaCualidad.aumentarVida(etapas);
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
