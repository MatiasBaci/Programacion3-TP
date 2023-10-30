package org.fiuba.algoritmos3;

public class ModificacionEstado implements  Modificacion{

    public void modificar(Cualidades cualidades,int etapas){
        if (cualidades.estaConsciente()) { //Tenias un Objecto a !getClass: EstadoNormal
            //cualidades.cambiarseEstado(new EstadoNormal()); // cambiarlo porque elimina todos los estados
            cualidades.cambiarLosEstadosA(new EstadoNormal());
        }
    }

    public  String obtenerNombreModificacion(){
        return "Estado";
    }
}
