package org.fiuba.algoritmos3;

// import javax.swing.plaf.PanelUI;

public class HabilidadEstadistica extends Habilidad{

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
            this.mostrarUso(unPokemon);

        } else {
            this.unaModificacion.modificar(pokemonOponente.getEstadisticas(),this.etapas);
            this.mostrarUso(pokemonOponente);
        }
    }


    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Modifica: " + this.unaModificacion.obtenerNombreModificacion());
        System.out.println("Cuantas Etapas: " + this.etapas);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }
    @Override
    public void mostrarUso(Pokemon unPokemon) {
        System.out.println("Se acaba de usar " + this.nombre + " que modifica " + this.unaModificacion.obtenerNombreModificacion() + ".");
        System.out.println("Las estadisticas de " + unPokemon.getNombre() + " son:");
        unPokemon.getEstadisticas().mostrarEstadisticas();
    }
}
