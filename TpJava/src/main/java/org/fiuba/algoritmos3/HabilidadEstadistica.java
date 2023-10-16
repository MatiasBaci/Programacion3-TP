package org.fiuba.algoritmos3;

// import javax.swing.plaf.PanelUI;

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


    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        if(!this.modificacionPropia){
            this.unaModificacion.modificar(cualidadesPokemonPropio,this.etapas);
        } else {
            this.unaModificacion.modificar(cualidadesPokemonEnemigo,this.etapas);
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

}
