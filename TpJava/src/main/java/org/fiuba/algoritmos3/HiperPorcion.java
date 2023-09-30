package org.fiuba.algoritmos3;

public class HiperPorcion extends Item{

    private Modificacion unaModificacion;

    public HiperPorcion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public void aplicarItem(Pokemon unPokemon) {
        unaModificacion.modificar(unPokemon.getEstadisticas(), 100);
    }

    public void mostrarItem() {
        System.out.println("Hiper Pocion: Restaura 100 de vida - Cantidad: " + cantidad);
    }
}

