package Pokemones;

import Modificaciones.Modificacion;
public class HabilidadEstadistica extends Habilidad{

    private String modificaEstadistica;

    private final boolean modificacionPropia;
    private final int etapas;

    private final Modificacion unaModificacion;


    public HabilidadEstadistica(String nombre, int cantidadDeUsos, boolean propio,int etapas,Modificacion modificar){
        super(nombre,cantidadDeUsos);
        this.modificacionPropia = propio;
        this.unaModificacion = modificar;
        this.etapas = etapas;
    }

    public String obtenerNombreModificacion(){
            return this.unaModificacion.obtenerNombreModificacion();
    }

    public int getEtapas() {
        return etapas;
    }

    public boolean isModificacionPropia() {
        return modificacionPropia;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        if(this.modificacionPropia){
            this.unaModificacion.modificar(cualidadesPokemonPropio,this.etapas);
        } else {
            this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
        }
    }
}
