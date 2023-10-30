package view;
import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Habilidad;
import org.fiuba.algoritmos3.HabilidadEstado;

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

        System.out.println("Es una habilida de Estado");

    }
}
