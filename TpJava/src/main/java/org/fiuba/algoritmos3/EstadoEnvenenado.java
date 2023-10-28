package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoEnvenenado extends Estado{

    public EstadoEnvenenado(){
        this.nombre = ESTADO_ENVENENADO;
        this.color = ANSI_FONDO_VIOLETA + ANSI_BLANCO;
    }
    

    @Override
    public boolean puedeAtacar(){
        return true;
    }


    @Override
    public void aplicarEfectoPasivoDeEstado() {
        this.cualidades.recibirDanio(this.cualidades.getVidaMaxima() * PORCENTAJE_VENENO);
    }
}
