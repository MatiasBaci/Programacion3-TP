package org.fiuba.algoritmos3;

import java.util.Objects;

import static org.fiuba.algoritmos3.Constantes.ESTADO_NORMAL;

public class ModificacionEstado implements  Modificacion{

    public void modificar(Cualidades cualidades,int etapas){
        if (!Objects.equals(cualidades.suEstadoEs(), ESTADO_NORMAL) && cualidades.estaConciente()) {
            cualidades.cambiarseEstado(new EstadoNormal());
        } else {
            System.out.println(" ");
            System.out.println("No se puede aplicar este item a un Pokemon Inhabilitado o Normal.");
        }


    }

    public  String obtenerNombreModificacion(){
        return "Estado";
    }
}
