package view.PokemonesView;
import Pokemones.Cualidades;
import Pokemones.HabilidadEstadistica;

import static org.fiuba.algoritmos3.Constantes.PORCENTAJE;

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
        System.out.println("Cantidad de usos: "  + this.habilidadEstadistica.getCantidadDeUsos());
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){

        if(!this.habilidadEstadistica.isModificacionPropia()){
            System.out.println("Se redujo la " + this.habilidadEstadistica.obtenerNombreModificacion() + " rival en " +
                    this.habilidadEstadistica.getEtapas() * PORCENTAJE * 100 + "%");
        } else {
            //this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
            System.out.println("Se aumento la " + this.habilidadEstadistica.obtenerNombreModificacion() + " propia en " +
                    this.habilidadEstadistica.getEtapas() * PORCENTAJE * 100 + "%");

        }

    }
}
