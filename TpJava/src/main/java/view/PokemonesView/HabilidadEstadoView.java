package view.PokemonesView;
import Pokemones.Cualidades;
import Pokemones.HabilidadEstado;

public class   HabilidadEstadoView extends HabilidadView{

    private HabilidadEstado habilidadEstado;

    public HabilidadEstadoView(HabilidadEstado habilidadEstado){
        super(habilidadEstado);
        this.habilidadEstado = habilidadEstado;
    }

    public void mostrar(){
        System.out.println("Nombre: " + habilidadEstado.getNombre());
        System.out.println("Estado: " + habilidadEstado.getUnEstado().getNombreConColor());
        System.out.println("Cantidad de usos: " + habilidadEstado.getCantidadDeUsos());
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){

        System.out.println("La habilidad usa el estado " +  habilidadEstado.getUnEstado().getNombreConColor());

    }
}
