package org.fiuba.algoritmos3;

public class MegaPocion extends Item{

    private Modificacion unaModificacion;

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public void aplicarItem(Pokemon unPokemon) {
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 50);
    }

    public void mostrarItem() {
        System.out.println("Pocion: Restaura 50 de vida - Cantidad: " + cantidad);
    }
}
