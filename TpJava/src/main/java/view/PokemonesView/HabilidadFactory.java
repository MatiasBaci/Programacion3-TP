package view.PokemonesView;
import org.fiuba.algoritmos3.Habilidad;
import org.fiuba.algoritmos3.HabilidadAtaque;
import org.fiuba.algoritmos3.HabilidadEstadistica;
import org.fiuba.algoritmos3.HabilidadEstado;


public class HabilidadFactory {

    public HabilidadView createHabilidadView(Habilidad habilidad){
        if(habilidad.getClass() == HabilidadAtaque.class){
            return new HabilidadAtaqueView((HabilidadAtaque) habilidad);
        }
        if(habilidad.getClass() == HabilidadEstadistica.class){
            return new HabilidadEstadisticaView((HabilidadEstadistica) habilidad);

        }
        return new HabilidadEstadoView((HabilidadEstado) habilidad);

    }
}
