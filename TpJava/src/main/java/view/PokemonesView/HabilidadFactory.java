package view.PokemonesView;
import Pokemones.*;


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
