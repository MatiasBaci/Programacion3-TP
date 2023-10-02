package org.fiuba.algoritmos3;

// import javax.swing.plaf.PanelUI;

public class HabilidadEstadistica extends Habilidad{

    private String modificaEstadistica;

    private boolean modificacionPropia;
    private int etapas;

    private Modificacion unaModificacion;


    public HabilidadEstadistica(String nombre, int cantidadDeUsos, boolean propio,int etapas,Modificacion modificar){
        super(nombre,cantidadDeUsos);
        this.modificacionPropia = propio;
        this.unaModificacion = modificar;
        this.etapas = etapas;
    }


    @Override
    public void usarHabilidad(Pokemon unPokemon, Pokemon pokemonOponente){
        this.cantidadDeUsos -= 1;
        if(!this.modificacionPropia){
            this.unaModificacion.modificar(unPokemon.getEstadisticas(),this.etapas);

        } else {
            this.unaModificacion.modificar(pokemonOponente.getEstadisticas(),this.etapas);
        }
    }


    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Modifica: " + this.modificaEstadistica);
        System.out.println("Cuantas Etapas: " + this.etapas);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }


}
