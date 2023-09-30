package org.fiuba.algoritmos3;

public class Pocion extends Item{

    private Modificacion unaModificacion;

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }

    public void aplicarItem(Pokemon unPokemon){
        unaModificacion.modificar(unPokemon.getEstadisticas(), 25);

    }

    @Override
    public void mostrarItem() {
        System.out.println("Pocion: Restaura 25 de vida - Cantidad: " + cantidad);
    }
}
