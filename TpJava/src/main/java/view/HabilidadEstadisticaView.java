package view;
import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Habilidad;
import org.fiuba.algoritmos3.HabilidadEstadistica;

public class HabilidadEstadisticaView extends HabilidadView{

    private HabilidadEstadistica habilidadEstadistica;

    public HabilidadEstadisticaView(HabilidadEstadistica habilidadEstadistica) {

        super(habilidadEstadistica);
        this.habilidadEstadistica = habilidadEstadistica;
    }

    public void mostrar(){
        System.out.println("Nombre: " + this.habilidadEstadistica.getNombre());
        System.out.println("Modifica: " + this.habilidadEstadistica.obtenerNombreModificacion());
        System.out.println("Cuantas Etapas: " + this.habilidadEstadistica.getEtapas());
        System.out.println("Cantidad de usos: " + this.habilidadEstadistica.getCantidadDeUsos());
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){

        if(!this.habilidadEstadistica.isModificacionPropia()){
            //this.unaModificacion.modificar(cualidadesPokemonPropio,this.etapas);
            System.out.println("Se uso una habilidad de estadistica sobre el enemigo");
        } else {
            //this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
            System.out.println("Se uso una habilidad de estadistica propia");
        }

    }
}
