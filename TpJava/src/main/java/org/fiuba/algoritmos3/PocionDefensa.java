package org.fiuba.algoritmos3;

public class PocionDefensa extends Item{

    private Modificacion unaModificacion;

    public PocionDefensa(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public void aplicarItem(Pokemon unPokemon) {
        this.cantidad --;
        this.itemUsado = true;
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 1);
    }

    public void mostrarItem() {
        System.out.println(nombre + ": Aumenta 10% la defensa - Cantidad: " + cantidad);
    }
}
