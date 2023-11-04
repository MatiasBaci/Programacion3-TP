package Estados;

import static org.fiuba.algoritmos3.Constantes.ANSI_BLANCO;
import static org.fiuba.algoritmos3.Constantes.ESTADO_NORMAL;

public class EstadoNormal extends Estado{

    public EstadoNormal(){
        this.nombre = ESTADO_NORMAL;
        this.color = ANSI_BLANCO;
    }

    @Override
    public boolean puedeAtacar(){

        return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
