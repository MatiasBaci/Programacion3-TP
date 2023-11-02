package Estados;
import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoNormal extends Estado{

    public EstadoNormal(){
        this.nombre = ESTADO_NORMAL;
        this.color = ANSI_BLANCO;
    }

    @Override
    public boolean puedeAtacar(){
        //this.eliminarse =true; --> esto es par que se elimine luego de saber ya tiene un efecto pero que pasa si no lo tiene
        // entonces deberia haber un this.cualidades.GetEstados.Size > 1 -> es ahi que debe eliminarse pero bueno veremos
        return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
